package P_2980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int N;
    static int D;
    static Traffic[] traffic;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        traffic = new Traffic[D + 1];
        visited = new boolean[D + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            traffic[index] = new Traffic(red, green);
            visited[index] = true;
        }

        for (int i = 1; i <= D; i++) {
            result++; //이동 시간 누적

            if (visited[i]) {
                //신호등을 만나면 대기 시간 누적
                int current = result % (traffic[i].red + traffic[i].green);
                if (current < traffic[i].red) {
                    result += traffic[i].red - current;
                }
            }
        }
        System.out.println(result);
    }

    static class Traffic {
        int red;
        int green;

        public Traffic(int red, int green) {
            this.red = red;
            this.green = green;
        }
    }
}
