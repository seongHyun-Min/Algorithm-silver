package P_11886;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Queue<Integer> q;
    static List<Integer> arr;
    static StringBuilder sb;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while(!q.isEmpty()){
            for(int i=0; i<K-1; i++){
                Integer before = q.poll();
                q.add(before);
            }
            arr.add(q.poll());
        }
        sb=  new StringBuilder();
        sb.append("<");
        for(int i=0; i<arr.size()-1; i++){
            sb.append(arr.get(i) +  ", ");
        }
        sb.append(arr.get(arr.size()-1) + ">");
        System.out.println(sb);
    }

}
