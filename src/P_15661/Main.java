package P_15661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N;
    static boolean[] visited;
    static int result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        result = Integer.MAX_VALUE;
        //input

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N];
        DFS(0, 0);
        System.out.println(result);
    }

    static void DFS(int start, int count) {
        if (count == N / 2) {
            int visit = 0;
            int inVisit = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visited[i] && visited[j]) {
                        visit += arr[i][j] + arr[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        inVisit += arr[i][j] + arr[j][i];
                    }
                }
            }
            int tmp = Math.abs(visit - inVisit);
            result = Math.min(tmp, result);
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            DFS(i + 1, count + 1);
            visited[i] = false;
        }
    }
}
