package P_3980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int[][] arr;
    static boolean[] visited;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            arr = new int[11][11];
            visited = new boolean[11];
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            result = 0;
            DFS(0, 0);
            System.out.println(result);
        }
    }

    static void DFS(int player, int sum) {
        if (player == 11) {
            result = Math.max(result, sum);
        } else {
            for (int i = 0; i < 11; i++) {
                if (!visited[i] && arr[player][i] != 0) {
                    visited[i] = true;
                    DFS(player + 1, sum + arr[player][i]); //그 포지션에 선수 할당
                    visited[i] = false;
                }
            }
        }
    }
}
