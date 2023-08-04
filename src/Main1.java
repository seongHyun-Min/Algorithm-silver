import java.util.*;
import java.io.*;

class Main1 {
    //시작 방향은 어디든 가능
    //상 우 하 좌로 시작
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int D; //방향
    static int N;
    static int K;
    static int[][] arr;
    static String result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = "NO";
        //input

        for(int i=0; i<4; i++){
            D = i;
            DFS(0, 0, D, 0);
            if(result.equals("YES")) break;
        }
        System.out.println(result);
    }
    static void DFS(int x, int y, int d, int count){
        if(count ==K && x ==N-1 && y ==N-1){
            result = "YES";
            return;
        }
        if(count <=K){
            //방향 전환 x
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx >=0 && nx < N && ny >=0 && ny <N && arr[nx][ny] ==0){
                DFS(nx, ny, d, count);
            }
            //오른쪽 방향 전환
            int direct = (d +1) % 4;
            nx = x + dx[direct];
            ny = y + dy[direct];
            if(nx >=0 && nx < N && ny >=0 && ny <N && arr[nx][ny] ==0){
                DFS(nx, ny, direct, count +1);
            }
            int leftDirect = (d +3) % 4;
            // 0 -> 3 , 1 -> 0, 2-> 1, 3-> 2 
            nx = x + dx[leftDirect];
            ny = y + dy[leftDirect];
            if(nx >=0 && nx < N && ny >=0 && ny <N && arr[nx][ny] ==0){
                DFS(nx, ny, leftDirect, count +1);
            }
        }
    }
}