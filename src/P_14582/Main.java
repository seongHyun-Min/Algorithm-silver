package P_14582;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    static int[] sA;
    static int aSum;
    static int[] B;
    static int[] sB;
    static int bSum;

    static boolean isTrue;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[10];
        B = new int[10];
        sA = new int[10];
        sB = new int[10];
        for (int i = 1; i < 10; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            aSum += A[i];
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < 10; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            bSum += B[i];
        }
        //구간합
        for (int i = 1; i < 10; i++) {
            sA[i] = sA[i - 1] + A[i];
            sB[i] = sB[i - 1] + B[i];
        }
        isTrue = false;
        for (int i = 1; i < 10; i++) {
            //구간합 중 sA가 sB 보다 큰적이 있었으면 역전패 가능성
            if (sA[i] > sB[i - 1]) {
                isTrue = true;
                break;
            }
        }
        if (aSum < bSum && isTrue) {
            System.out.println("Yes");
        } else System.out.println("No");
    }
}
