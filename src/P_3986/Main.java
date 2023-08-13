package P_3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N;
    static int result;

    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result =0;
        for (int i = 0; i < N; i++) {
            String target = br.readLine();
            isGood(target);
        }
        System.out.println(result);
    }

    static void isGood(String target) {
        stack = new Stack<>();
        for (char c : target.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                //스택에 넣었던게 같은거면 pop
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) result++;
    }
}
