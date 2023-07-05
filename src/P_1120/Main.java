package P_1120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String A;
    static String B;

    static int result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = st.nextToken();

        char[] a = A.toCharArray();

        result = Integer.MAX_VALUE;

        //B를 짤라서 최소값을 구한것이 정답

        for (int i = 0; i <= B.length() - A.length(); i++) {
            String target = B.substring(i, A.length() + i);
            char[] b = target.toCharArray();
            int count = 0;
            for (int j = 0; j < A.length(); j++) {
                if (a[j] != b[j]) count++;
            }
            result = Math.min(count, result);
        }

        System.out.println(result);
    }
}
