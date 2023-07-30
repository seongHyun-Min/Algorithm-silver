package P_5567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    //depth가 2이하인 인원 찾기
    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] visited;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
            //양방향 input
        }
        result = 0;
        visited = new boolean[N + 1];
        visited[1] = true;
        DFS(1, 0);
        for (int i = 2; i <= N; i++) {
            if (visited[i]) {
                result++;
            }
        }
        System.out.println(result);

    }

    static void DFS(int start, int count) {
        if (count < 2) {
            for (int friend : arr.get(start)) {
                visited[friend] = true;
                DFS(friend, count + 1);
            }
        }
    }
}
