package P_17068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    //8방향
    static int result;

    static Queue<Shark> q;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        result = 0;
        arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //1이면 BFS 탐색
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    result = Math.max(BFS(i, j), result);
                }
            }
        }
        System.out.println(result);
    }

    static int BFS(int x, int y) {
        q = new LinkedList<>();
        visited = new boolean[M][N];
        visited[x][y] = true;
        q.add(new Shark(x, y, 0));

        while (!q.isEmpty()) {
            Shark current = q.poll();
            if (arr[current.x][current.y] == 1) {
                return current.dist;
            }
            for (int i = 0; i < 8; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Shark(nx, ny, current.dist + 1));
                    }
                }
            }
        }
        //못찾으면 min 값 리턴
        return 0;
    }

    static class Shark {
        int x;
        int y;
        int dist;

        public Shark(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
