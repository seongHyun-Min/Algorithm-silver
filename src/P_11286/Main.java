package P_11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static PriorityQueue<Integer> q;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        q = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return Integer.compare(o1, o2);
            }
            return Integer.compare(Math.abs(o1), Math.abs(o2));
        });
        while (N != 0) {
            N--;
            int target = Integer.parseInt(br.readLine());
            if (target != 0) {
                q.add(target);
            } else {
                if (!q.isEmpty()) {
                    System.out.println(q.poll());
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
