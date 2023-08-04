import java.util.*;
import java.io.*;

class Main3 {
    //구간합
    static int[] arr;
    static int N, K;
    static int[] S;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        S = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //구간합 넣기
        for (int i = 1; i <= N; i++) {
            S[i] = S[i - 1] + arr[i];
        }
        result = Integer.MIN_VALUE;
        for (int i = 0; i <= N - K; i++) {
            result = Math.max(result, S[i+K] - S[i]);
        }
        System.out.println(result);
    }
}