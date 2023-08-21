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
        result = 1;

        while (A <= B) {
            result++;
            if (B % 10 == 1) {
                B /= 10;
            } else if(B %2 ==0){
                B /= 2;
            }else{
                //못구해
                break;
            }
            if(A==B) break;
        }
        if(A==B){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }
    }
}
