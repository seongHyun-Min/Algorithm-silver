import java.io.*;
import java.util.StringTokenizer;

class Main7 {
    static int N, K;
    static int[][] arr;
    static int[] dx = {1, 0, -1 ,0 ,1 , -1, -1, 1};
    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    static int result;
    public static void main(String[] args) throws Exception {
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
        //input
        result =0;


        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] ==0){
                    int count =BFS(i, j);
                    System.out.println("i = " + i);
                    System.out.println("j = " + j);
                    System.out.println("count = " + count);
                    if(count ==K){
                        result ++;
                    }
                }
            }
        }
        System.out.println(result);

    }

    static int BFS(int x, int y){
        int count =0;
        for(int i=0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >=0 && nx < N && ny>=0 && ny<0){
                if(arr[nx][ny] ==1){
                    count ++;
                }
            }
        }
        return count;
    }


}