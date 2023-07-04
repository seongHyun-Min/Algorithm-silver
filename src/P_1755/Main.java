package P_1755;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Number> numList;

    static int N, M;

    static String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numList = new ArrayList<>();

        for (int i = N; i <= M; i++) {
            String result = "";
            String tmp = String.valueOf(i);
            for (int j = 0; j < tmp.length(); j++) {
                result += arr[tmp.charAt(j) - '0'];
            }
            numList.add(new Number(result, i));
        }
        Collections.sort(numList);

        int count = 0;

        for (int i = 0; i < numList.size(); i++) {
            System.out.print(numList.get(i).value + " ");
            count++;
            if (count == 10) {
                System.out.println();
                count = 0;
            }
        }
    }

    static class Number implements Comparable<Number> {
        String num;
        int value;

        public Number(String num, int value) {
            this.num = num;
            this.value = value;
        }


        @Override
        public int compareTo(Number o) {
            return num.compareTo(o.num);
        }
    }

}
