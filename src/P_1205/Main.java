package P_1205;

import java.util.*;

class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int result;
    static int[][] arr;

    public int solution(int[][] board) {
        N = board.length;
        result = Integer.MAX_VALUE;
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = board[i][j];
                System.out.print(arr[i][j] + " ");
            }
        }

        DFS(0, 0, 4, 0, 0);
        return result;


    }

    static void DFS(int x, int y, int direct, int count, int edge) {
        if (x == N - 1 && y == N - 1) {
            int cost = (100 * count) + (500 * edge);
            result = Math.min(result, cost);
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] != 1) {
                    if (direct == 4) {
                        //첫번째 출발인 경우
                        DFS(nx, ny, i, count + 1, edge);
                    } else {
                        if (direct != i) {
                            DFS(nx, ny, i, count + 1, edge + 1);
                        } else {
                            DFS(nx, ny, i, count + 1, edge);
                        }
                    }
                }
            }
        }
    }
}