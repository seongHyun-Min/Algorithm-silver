package P_2491;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        result = 1;
        int increaseCount = 1;
        int decreaseCount = 1;

        for (int i = 1; i < N; i++) {
            if (arr[i] >= arr[i - 1]) {
                increaseCount++;
            } else increaseCount = 1;
            result = Math.max(result, increaseCount);
        }
        for (int i = 1; i < N; i++) {
            if (arr[i] <= arr[i - 1]) {
                decreaseCount++;
            } else decreaseCount = 1;
            result = Math.max(result, decreaseCount);
        }
        System.out.println(result);
    }
}
