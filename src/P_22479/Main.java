package P_22479;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, S;
    static ArrayList<ArrayList<Integer>> arr;
    static int[] visited;

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        visited = new int[N + 1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr.get(u).add(v);
            arr.get(v).add(u);
        }

        //오름차순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(arr.get(i));
        }

        count = 1;
        DFS(S);
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(int start) {
        visited[start] = count;

        for (int next : arr.get(start)) {
            if (visited[next] == 0) {
                count++;
                DFS(next);
            }
        }
    }
}
