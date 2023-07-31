package P_10157;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int K;
    static int[][] arr;
    static int X, Y;
    static Queue<Point> q;

    static int count;

    //상 우 하 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        arr = new int[M][N];
        X = -1;
        Y = -1;
        D = 0;
        q = new LinkedList<>();
        count = 1;
        q.offer(new Point(M - 1, 0));

        while (!q.isEmpty()) {
            Point current = q.poll();
            if (count == K) {
                X = current.y + 1;
                Y = M - current.x;
            }
            arr[current.x][current.y] = count++;
            int nx = current.x + dx[D];
            int ny = current.y + dy[D];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && arr[nx][ny] == 0) {
                q.offer(new Point(nx, ny));
            } else {
                D = (D + 1) % 4;
                nx = current.x + dx[D];
                ny = current.y + dy[D];
                if (arr[nx][ny] == 0) {
                    q.offer(new Point(nx, ny));
                }
            }
        }
        if(X == -1 && Y == -1){
            System.out.println(0);
        }else System.out.println(X + " " + Y);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
