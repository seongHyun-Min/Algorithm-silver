package P_2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static Queue<Integer> card;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        card = new LinkedList<>();
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            card.add(i);
        }
        while(card.size() != 1){
            card.poll(); //하나 버리고
            int second = card.poll();
            card.add(second);
        }
        System.out.println(card.poll());
    }
}
