package P_16918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;

    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                if (tmp.charAt(j) == '.') {
                    arr[i][j] = -1;
                } else {
                    arr[i][j] = 2;
                    //다음 1초 동안 봄버맨은 아무것도 하지 않는다.
                }
            }
        }

        DFS(1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == -1) {
                    System.out.print(".");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    static void DFS(int count) {
        if (count < K) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    //count가 홀수면 폭탄을 설치
                    if (count % 2 == 1) {
                        if (arr[i][j] == -1) {
                            arr[i][j] = 3;
                        } else {
                            arr[i][j]--;
                        }
                    } else {//count가 짝수면 폭탄을 폭발
                        if (arr[i][j] != -1) {
                            arr[i][j]--;
                            if (arr[i][j] == 0) {
                                for (int k = 0; k < 4; k++) {
                                    int nx = i + dx[k];
                                    int ny = j + dy[k];
                                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                                        if (arr[nx][ny] != 1) {
                                            arr[nx][ny] = -1; // 폭발한 영향을 주변 칸에 전파
                                        }
                                    }
                                }
                                arr[i][j] = -1; // 폭발한 폭탄은 빈 칸으로 변환
                            }
                        }
                    }
                }
            }
            DFS(count + 1);
        }
    }
}
