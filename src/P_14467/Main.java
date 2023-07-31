package P_14467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<Integer, Integer> map;
    static int N;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        result = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if (map.containsKey(key)) {
                if (map.get(key) != value) {
                    result++;
                }
            }
            map.put(key, value);
        }
        System.out.println(result);
    }
}
