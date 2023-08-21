package P_20365;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //파란색, 빨간색 구간을 찾아서 갯수를 더하고 작은거 +1이 정답
    static int N;
    static String target;
    static char[] arr;
    static int red;
    static int blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        target = br.readLine();
        arr = target.toCharArray();
        red = 0;
        blue = 0;
        char prior = ' ';

        for (char c : arr) {
            if (c != prior) {
                if (c == 'R') {
                    red++;
                } else blue++;
                prior = c;
            }
        }
        System.out.println(Math.min(red, blue) + 1);
    }
}
