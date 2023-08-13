package P_2576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int sum;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sum = 0;
        min = Integer.MAX_VALUE;
        for (int i = 0; i < 7; i++) {
            int target = Integer.parseInt(br.readLine());
            if (target % 2 == 1) {
                sum += target;
                min = Math.min(min, target);
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

}
