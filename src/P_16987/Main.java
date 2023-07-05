package P_16987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//계란은 왼쪽부터 들어서 한 번씩만 다른 계란을 칠수 있음 (다른 계란중 하나만 가능)
//구현, 완전탐색
public class Main {
    static Egg[] eggs;
    static int N;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int durability = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            eggs[i] = new Egg(durability, weight);
        }
        max = 0;

        DFS(0, 0);
        System.out.println(max);
    }

    static void DFS(int current, int sum) {
        // DFS 시작시점마다 갱신
        max = Math.max(max, sum);
        if (current == N) {
            //끝까지 계란을 들었으면 max 갱신
            // max = Math.max(max, sum);
            // 92% 에서 계속 틀린이유?? 계란이 깨지면 끝까지 못갈 수도 있는데
            // 끝까지 간 상황에서만 max값을 갱신한 오류

        } else {
            //들고 있는 계란이 깨져있으면 다른 계란을 깰수 없음
            if (eggs[current].durability > 0) {
                for (int i = 0; i < N; i++) {
                    int count = 0; //깨는 계란 수 더하기

                    //자기자신과 맞는 계란이 깨져있다면 깰수 없음
                    if (i == current || eggs[i].durability <= 0) continue;

                    //계란 치기
                    eggs[current].durability -= eggs[i].weight;
                    eggs[i].durability -= eggs[current].weight;

                    if (eggs[current].durability <= 0) count++;
                    if (eggs[i].durability <= 0) count++;

                    DFS(current + 1, sum + count);

                    //계란 복구
                    eggs[current].durability += eggs[i].weight;
                    eggs[i].durability += eggs[current].weight;

                }
            } else {
                DFS(current + 1, sum);
            }
        }
    }


    static class Egg {
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }
}