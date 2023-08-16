package P_1080;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] A;
    static int[][] B;
    static int N, M;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        B = new int[N][M];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = tmp.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                B[i][j] = tmp.charAt(j) - '0';
            }
        }
        result = 0;
        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                if (A[i][j] != B[i][j]) {
                    flip(i, j);
                    result++;
                }
            }
        }
        if (isTrue(A)) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    static void flip(int row, int col) {
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                A[i][j] = 1 - A[i][j];
            }
        }
    }

    static boolean isTrue(int[][] target) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (target[i][j] != B[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
