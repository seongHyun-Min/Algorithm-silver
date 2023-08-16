package P_10431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            result = 0;
            arr = new int[20];
            for(int i=0; i<20; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < 19; i++) {
                for (int j = i + 1; j < 20; j++) {
                    if (arr[i] > arr[j]) {
                        result++;
                    }
                }
            }
            System.out.print(t + " ");
            System.out.println(result);
        }
    }
}
