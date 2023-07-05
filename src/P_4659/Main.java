package P_4659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String target;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            target = br.readLine();
            if (target.equals("end")) break;


            if (firstTest(target) && secondTest(target) && thirdTest(target)) {
                System.out.println("<" + target + "> is acceptable.");
            } else {
                System.out.println("<" + target + "> is not acceptable.");
            }


        }

    }

    static boolean firstTest(String target) {
        return target.matches(".*[aeiou].*");
    }

    static boolean secondTest(String target) {
        return !target.matches(".*(aaa|eee|iii|ooo|uuu|[^aeiou]{3}).*");
    }

    static boolean thirdTest(String target) {
        boolean isTrue = true;
        for (int i = 0; i <= target.length() - 2; i++) {
            String tmp = target.substring(i, i + 2);
            if (tmp.equals("ee") || tmp.equals("oo")) continue;
            if (tmp.charAt(0) == tmp.charAt(1)) {
                isTrue = false;
                break;
            }
        }
        return isTrue;
    }
}


