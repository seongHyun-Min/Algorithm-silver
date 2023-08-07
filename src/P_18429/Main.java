package P_18429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    //가능한 경우의수의 총합
    static boolean[] visited;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        result = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0, 0);

        System.out.println(result);
    }

    static void DFS(int count, int sum) {
        if (count == N - 1) {
            result++;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i] && sum >= 0) {
                //방문 안했으면 방문
                visited[i] = true;
                DFS(count + 1, sum + (arr[i] - M));
                visited[i] = false;
            }
        }
    }

}
