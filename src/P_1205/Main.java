package P_1205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, score, P;
    static int[] arr;
    static boolean isIn;
    static int rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        score = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        arr = new int[N];
        if(N ==0){
            System.out.println(1);
            System.exit(0);
        }else{
            st = new StringTokenizer(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        isIn = true;
        //랭킹 리스트에 들어갈수 없는 경우
        //N이 P와 같은 경우에 리스트에서 작은 값이 들어올 경우
        if (N == P && score <= arr[0]) {
            isIn = false;
            System.out.println(-1);
        }

        rank = 1;
        if (isIn) {
            //등수를 구하자
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] > score) {
                    rank++;
                }else{
                    break;
                }
            }
        }
        System.out.println(rank);
    }
}
