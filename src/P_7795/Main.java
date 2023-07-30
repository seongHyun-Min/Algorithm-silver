package P_7795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N, M;
    static int[] A;
    static int[] B;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N];
            B = new int[M];


            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }


            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);
            Arrays.sort(B);

            result = 0;
            for (int j = 0; j < N; j++) {
                int left = 0;
                int right = M - 1;
                int target = A[j];
                int count = -1;

                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (B[mid] < target) {
                        count = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                result += count + 1;
            }

            System.out.println(result);
        }
    }
}
