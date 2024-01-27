package 삼성SW역량테스트.왕실의기사대결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int L, N, Q;

    static Solider[] solider;

    static int result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        map = new int[L][L];

        // map Input


        for(int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<L;j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // solider Input
        solider = new Solider[N+1];
        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            solider[i] = new Solider(r, c, h, w, k);
        }

        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            //죽으면 안돼
            if(solider[num].isLife){

            }

        }








    }



    static class Solider{
        // 00 기준으로 r-1 c-1
        int r;
        int c;
        int h;
        int w;
        int k;
        boolean isLife;

        public Solider(int r, int c, int h, int w, int k){
            this.r = r;
            this.c = c;
            this.h = h;
            this.w = w;
            this.k = k;
            this.isLife = true;
        }

        public void updateSolider(){
            this.isLife = false;
        }
    }

    class Solution {
        public int solution(int[] bandage, int health, int[][] attacks) {
            int maxHealth = health;
            int curTime = 0;
            for(int i=0; i<attacks.length   ; i++){
                int time = attacks[i][0];
                int damage = attacks[i][1];
                int timeDiff = time - curTime - 1;
                int healingAmount = (bandage[1] * timeDiff)
                        + bandage[2] * (timeDiff/bandage[0]);

                if(health + healingAmount >= maxHealth){
                    health = maxHealth;
                } else{
                    health += healingAmount;
                }
                health -= damage;
                if(health<=0) return -1;
                curTime = time;
            }
            return health;
        }
    }
}