package P_13335;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //최소시간 그리디?
    static Queue<Integer> bridge;
    static int N, W, L;

    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        bridge = new LinkedList<>();
        st = new StringTokenizer(br.readLine());

        int totalBridgeWeight = 0;
        //현재 다리위에 있는 트럭들의 무게의 합
        time = 0;
        for (int i = 0; i < N; i++) {
            int truckWeight = Integer.parseInt(st.nextToken());

            while (true) {
                //다리에 트럭이 없는 경우에 트럭을 넣어주면 돼
                if (bridge.isEmpty()) {
                    bridge.add(truckWeight);
                    totalBridgeWeight += truckWeight;
                    time++;
                    break;
                } else {
                    //다리에 트럭이 있는경우 경우의수
                    //1.다리위에 트럭이 모두 최대치로 올라와 있는경우
                    if (bridge.size() == W) {
                        totalBridgeWeight -= bridge.poll();
                    } else {//2.아직 다리에 트럭을 올릴수 있는경우
                        if (totalBridgeWeight + truckWeight <= L) {
                            //2.1 트럭을 올릴수 있는경우
                            bridge.add(truckWeight);
                            totalBridgeWeight += truckWeight;
                            time++;
                            break;
                        } else { //2.2 트럭을 올릴수 있으나 무게가 최대 무게를 초과하는 경우
                            //대기 큐를 하나 넣어서 시간을 증가 시킨다. (대기 큐를 넣는 이유 다음 트럭이 빠저나가기 위해서 한칸씩 밀어주는 느낌)
                            bridge.add(0);
                            time++;
                        }
                    }
                }

            }
        }
        System.out.println(time + W);

    }
}
