package P_16205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static String target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        target = st.nextToken();

        if (N == 1) {//카멜케이스인 경우
            System.out.println(target);
            //카멜 -> snake
            StringBuilder snake = new StringBuilder();
            for (char c : target.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    //대문자 인경우
                    snake.append("_").append(Character.toLowerCase(c));
                } else {
                    snake.append(c);
                }
            }
            System.out.println(snake);
            //카멜 -> 파스칼
            String first = target.substring(0, 1).toUpperCase();
            String paskal = target.substring(1);
            System.out.println(first + paskal);

        } else if (N == 2) { //스네이크인 경우
            StringBuilder camel = new StringBuilder();
            boolean toUpper = false;
            // _를 찾아서 뒤에 있는변수를 대문자로 변경
            for (char c : target.toCharArray()) {
                if (c == '_') {
                    toUpper = true;
                } else {
                    if (toUpper) {
                        camel.append(Character.toUpperCase(c));
                    } else {
                        camel.append(c);
                    }
                }
            }
            System.out.println(camel);
            System.out.println(target);
            //camel -> 앞에만 대문자로 변경
            String first = camel.substring(0, 1).toUpperCase();
            String paskal = camel.substring(1);
            System.out.println(first + paskal);
        } else {
            //paskal인 경우
            String first = target.substring(0, 1).toLowerCase();
            String two = target.substring(1);
            String camel = first + two;
            System.out.println(camel);

            //camel에서 snake로 변경
            StringBuilder snake = new StringBuilder();
            for (char c : camel.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    //대문자인경우
                    snake.append("_").append(Character.toLowerCase(c));
                } else {
                    snake.append(c);
                }
            }
            System.out.println(snake);
            System.out.println(target);
        }

    }
}
