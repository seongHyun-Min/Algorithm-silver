package P_1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Integer> q;

    static int N, K;

    static ArrayList<Integer> result;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();
        result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                int before = q.poll();
                q.add(before);
            }
            result.add(q.poll());
        }
        sb.append("<");
        for (int i = 0; i < result.size() - 1; i++) {
            sb.append(result.get(i) + ", ");
        }

        sb.append(result.get(N - 1) + ">");

        System.out.println(sb.toString());
    }
}
