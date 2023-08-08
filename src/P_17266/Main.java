package P_17266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //이분 탐색
    static int N, M;
    static int[] arr;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        int left = 0;
        int right = N;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean isTrue = true;
            //mid값으로 가능한가?
            int pre = 0;
            for (int i = 0; i < M; i++) {
                if (arr[i] - mid > pre) {
                    //간격이 이전보다 크면 안돼
                    isTrue = false;
                    break;
                }
                pre = arr[i] + mid; //이전값 업데이트
            }
            if (N - arr[M - 1] > mid) {
                isTrue = false;
            }
            if (isTrue) {
                //가능하다면 결과값 업데이트
                result = mid;
                //가능하면 mid값을 줄여서 결과값 갱신
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
}
