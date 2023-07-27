package P_16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A;
    static int B;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;

        DFS(A, 1);
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else System.out.println(result);
    }

    public static void DFS(long start, int count) {
        if (start <= B) {
            if (start == B) {
                result = Math.min(result, count);
            } else {
                //2를 곱해
                DFS(start + 2, count + 1);
                //1을 오른쪽 추가
                String tmp = start + "1";
                DFS(Long.parseLong(tmp), count + 1);
            }
        }
    }
}
