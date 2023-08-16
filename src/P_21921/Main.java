package P_21921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] S;

    static int maxCount;

    static int period;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        S = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //input

        for (int i = 1; i <= N; i++) {
            S[i] = S[i - 1] + arr[i];
        }

        maxCount = 0;
        for (int i = M; i <= N; i++) {
            maxCount = Math.max(maxCount, S[i] - S[i - M]);
        }
        if (maxCount != 0) {
            for (int i = M; i <= N; i++) {
                if (S[i] - S[i - M] == maxCount) {
                    period++;
                }
            }
            System.out.println(maxCount);
            System.out.println(period);
        }else{
            System.out.println("SAD");
        }
    }
}
