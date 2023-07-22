package P_18110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] arr;

    static int round;

    static double sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        round = (int) (N * 0.15 + 0.5);

        sum = 0;
        Arrays.sort(arr);
        for (int i = round; i < N - round; i++) {
            sum += arr[i];
        }
        int result = (int) Math.round(sum / (N - 2 * round));
        System.out.println(result);
    }
}
