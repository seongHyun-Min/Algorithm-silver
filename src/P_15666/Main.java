package P_15666;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static HashSet<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        result = new LinkedHashSet<>();
        DFS(0, 0, "");

        for (String s : result) {
            System.out.println(s);
        }
    }
    static void DFS(int start, int count, String tmp){
        if(count == M){
            result.add(tmp);
        }else{
            for(int i=start; i<N; i++){
                //고르는 경우
                DFS(i, count+1, tmp + arr[i] + " ");
                //고르지 않는 경우
                DFS(i+1, count, tmp);
            }
        }
    }
}
