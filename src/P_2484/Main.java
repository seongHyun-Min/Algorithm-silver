package P_2484;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result;
    static int N;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        result = 0;
        for (int i = 0; i < N; i++) {
            arr = new int[7];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int target = Integer.parseInt(st.nextToken());
                arr[target]++;
            }
            int sum = 0;
            int maxCount = 0;
            int maxIndex = 0;
            for (int k = 1; k <= 6; k++) {
                if (maxCount <= arr[k]) {
                    maxCount = arr[k];
                    maxIndex = k;
                }
            }
            if (maxCount == 4) {
                sum = 50000 + maxIndex * 5000;
            } else if (maxCount == 3) {
                sum = 10000 + maxIndex * 1000;
            } else if (maxCount == 2) {
                //2라면 두쌍이 나오는지 확인
                int twoIndex = 0;
                for (int k = 1; k <= 6; k++) {
                    if (k == maxIndex) continue;
                    if (arr[k] == 2) {
                        twoIndex = k;
                    }
                }
                if (twoIndex != 0) {
                    sum = 2000 + (maxIndex * 500) + (twoIndex * 500);
                } else {
                    sum = 1000 + maxIndex * 100;
                }
            } else {
                sum = maxIndex * 100;
            }
            result = Math.max(sum, result);
        }
        System.out.println(result);
    }
}
