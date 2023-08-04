package P_5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String str;
    static String OI = "OI";

    static int N, M;

    static String target;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = "I";
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            str += OI;
        }
        result = 0;
        M = Integer.parseInt(br.readLine());
        target = br.readLine();
        for (int i = 0; i < M - str.length(); i++) {
            if (target.charAt(i) == 'I') {
                String tmp = target.substring(i, i + str.length());
                System.out.println(tmp);
                if (tmp.equals(str)) result++;
            }
        }
        System.out.println(result);
    }
}
