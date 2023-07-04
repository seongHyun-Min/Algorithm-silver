package P_12847;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;

    static long[] S; //구간합
    static long max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        S = new long[N + 1];
        max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        S[1] = arr[1];
        for (int i = 2; i <= N; i++) {
            S[i] = arr[i] + S[i - 1];
        }

        for (int i = M; i <= N; i++) {
            long sum = S[i] - S[i - M];
            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}
