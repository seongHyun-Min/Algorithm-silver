package P_5800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int K;
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        num = 0;
        while (K != 0) {
            K--;
            num++;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int max = 0;
            for (int i = 0; i < N - 1; i++) {
                max = Math.max(max, arr[i + 1] - arr[i]);
            }
            System.out.println("Class " + num);
            System.out.println("Max " + arr[N - 1] + ", Min " + arr[0] + ", Largest gap " + (max));
        }
    }
}
