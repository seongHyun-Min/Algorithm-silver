package P_16173;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static Queue<Jelly> q;
    static int[][] map;
    static boolean[][] visited;
    static int N;

    static boolean isTrue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        //input
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //BFS
        isTrue = false;
        q = new LinkedList<>();
        q.offer(new Jelly(0, 0, map[0][0]));
        BFS();
        if (isTrue) {
            System.out.println("HaruHaru");
        } else System.out.println("Hing");
    }

    static void BFS() {
        while (!q.isEmpty()) {
            Jelly jelly = q.poll();
            int x = jelly.x;
            int y = jelly.y;
            visited[x][y] = true;

            if (x == N - 1 && y == N - 1) {
                isTrue = true;
                return;
            }

            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i] * jelly.weight;
                int ny = y + dy[i] * jelly.weight;

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny]) {
                        q.offer(new Jelly(nx, ny, map[nx][ny]));
                    }
                }
            }
        }
    }

    static class Jelly {
        int x;
        int y;
        int weight;

        public Jelly(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
}
