package P_6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;

    static boolean[] visited;

    static ArrayList<String> result;

    static StringBuilder sb;


    //N개 숫자중에서 6개 골라서 백트래킹 중복 불가 나올수 있는 경우의수 모두 출력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) break;
            arr = new int[N];
            visited = new boolean[N];
            result = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            //input

            DFS(0, 0);

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void DFS(int start, int count) {
        if (count == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(result.get(i));
            }
            sb.append("\n");
        } else {
            for (int i = start; i < N; i++) {
                String tmp = arr[i] + " ";
                result.add(tmp);
                visited[i] = true;
                DFS(i + 1, count + 1);
                result.remove(result.size() - 1);
                visited[i] = false;
            }
        }
    }


}
