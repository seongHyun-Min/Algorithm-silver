package P_1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //큐를 탐색할때 for-each문을 사용하면 큐의 사이즈의 변경없이
    //즉, 큐에서 꺼내서 다시 큐에 넣는것이 아니라 큐 내의 내용들을 반복적으로 확인이 가능함
    static int T;
    static int N, M;
    static Queue<Print> q;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            q = new LinkedList<>();
            result = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int score = Integer.parseInt(st.nextToken());
                if (i == M) {
                    q.offer(new Print(score, true));
                } else {
                    q.offer(new Print(score, false));
                }
            }
            //input

            while (!q.isEmpty()) {
                Print current = q.poll();
                boolean isPrint = true;
                //중요도가 높은 문서 확인
                for(int i=0; i<q.size(); i++)
                for (Print next : q) {
                    if (current.score < next.score) {
                        //큐를 변경하지 않고 순차적으로 큐 확인
                        //이 코드를 사용하면 break를 사용할수 있어 시간을 단축시킬수 있음
                        isPrint = false;
                        break;
                        //큐를 peek하는 과정에서는 큐에 추가 삭제가 일어나서는 안됨
                    }
                }
                if (isPrint) {
                    result++;
                    if (current.isTarget) {
                        System.out.println(result);
                        break;
                    }
                } else {
                    q.add(current);
                }
            }
        }
    }


    static class Print {
        int score;
        boolean isTarget;

        public Print(int score, boolean isTarget) {
            this.score = score;
            this.isTarget = isTarget;
        }
    }
}
