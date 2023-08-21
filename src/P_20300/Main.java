package P_20300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //두수를 고르는데 가장 작은 합을 골라야함
    //투포인터
    static int N;
    static long[] arr;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        result = 0;

        int left = 0;
        int right;
        if (N % 2 == 1) {
            right = N - 2;
        } else {
            right = N - 1;
        }
        while (left <= right) {
            result = Math.max(result, arr[left] + arr[right]);
            left++;
            right--;
        }
        if (N % 2 == 1) {
            result = Math.max(result, arr[N - 1]);
        }
        System.out.println(result);

    }
}
