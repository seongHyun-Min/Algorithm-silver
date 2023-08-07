package P_20125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    //심장의 위치를 찾는방법 상하좌우가 *이면 심장
    static int leftArm;
    static int rightArm;
    static int mid;
    static int leftLeg;
    static int rightLeg;
    static char[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int HeartX;
    static int HeartY;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = tmp.charAt(j);
            }
        }
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (arr[i][j] == '*') {
                    if (isHeart(i, j)) {
                        HeartX = i;
                        HeartY = j;
                    }
                }
            }
        }
        leftArm = 0;
        for (int i = HeartY - 1; i >= 0; i--) {
            if (arr[HeartX][i] == '*') leftArm++;
        }
        rightArm = 0;
        for (int i = HeartY + 1; i < N; i++) {
            if (arr[HeartX][i] == '*') rightArm++;
        }
        mid = 0;
        for (int i = HeartX + 1; i < N; i++) {
            if (arr[i][HeartY] == '*') mid++;
        }
        leftLeg = 0;
        for (int i = HeartX + 1; i < N; i++) {
            if (arr[i][HeartY - 1] == '*') leftLeg++;
        }
        rightLeg = 0;
        for (int i = HeartX + 1; i < N; i++) {
            if (arr[i][HeartY + 1] == '*') rightLeg++;
        }
        System.out.println((HeartX + 1) + " " + (HeartY + 1));
        System.out.println(leftArm + " " + rightArm + " " + mid + " " + leftLeg + " " + rightLeg);

    }

    static boolean isHeart(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] != '*') {
                return false;
            }
        }
        return true;
    }
}
