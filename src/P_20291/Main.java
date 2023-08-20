package P_20291;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashMap<String, Integer> map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String target = br.readLine();
            //. 이스케이프 문자열
            String[] split = target.split("\\.");

            map.put(split[1], map.getOrDefault(split[1], 0) + 1);
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        for (String key : keySet) {
            System.out.print(key + " ");
            System.out.println(map.get(key));
        }
    }
}
