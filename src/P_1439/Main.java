package P_1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //0이 누적되는 구간과 1이 누적되는 구간의 count를 구해서 최소값을 리턴
    static int oneCount;
    static int zeroCount;
    static String target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = br.readLine();
        oneCount = 0;
        zeroCount = 0;

        char pre = target.charAt(0);
        if (pre == '0') {
            zeroCount++;
        } else {
            oneCount++;
        }

        for (int i = 1; i < target.length(); i++) {
            char current = target.charAt(i);
            if (pre != current) {
                if (pre == '0') {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }
            pre = current;
        }

        System.out.println(Math.min(oneCount, zeroCount));
    }
}
