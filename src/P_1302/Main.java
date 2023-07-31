package P_1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashMap<String, Integer> map;
    static int N;
    static int maxCount;
    static List<String> answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        maxCount = 0;
        for (int value : map.values()) {
            maxCount = Math.max(maxCount, value);
        }
        answer = new ArrayList<>();

        map.forEach((key, value) -> {
            if (value == maxCount) {
                answer.add(key);
            }
        });
        Collections.sort(answer);
        System.out.println(answer.get(0));
    }
}
