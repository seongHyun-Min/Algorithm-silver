import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 배열 초기화
        dp[N - 1][0] = arr[N - 1][0]; // (n, 1)에서 시작하여 오른쪽으로 이동
        for (int i = N - 2; i >= 0; i--) {
            dp[i][0] = dp[i + 1][0] + arr[i][0]; // 위로 이동
        }
        for (int j = 1; j < N; j++) {
            dp[N - 1][j] = dp[N - 1][j - 1] + arr[N - 1][j]; // 오른쪽으로 이동
        }

        // dp 배열 채우기
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }

        // 최종 결과 출력
        System.out.println(dp[0][N - 1]);
    }
}
