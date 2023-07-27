package P_2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //연속적인 온도의 합이 가장 큰 값 구간합 이용
    static int N, K;
    static int arr[];
    static int S[];

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        result = Integer.MIN_VALUE;
        arr = new int[N + 1];
        S = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //구간합 만들기
        for (int i = 1; i <= N; i++) {
            S[i] = S[i - 1] + arr[i];
        }

        //최대값 찾기
        for (int i = K; i <= N; i++) {
            result = Math.max(result, S[i] - S[i - K]);
        }
        System.out.println(result);
    }
}
