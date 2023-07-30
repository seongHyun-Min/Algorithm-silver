package P_9357;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N;
    static HashMap<String, Integer> map;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String value = st.nextToken(); //사용 xx
                String key = st.nextToken();
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            result = 1;
            for (int count : map.values()) {
                result *= (count + 1);
            }
            System.out.println(result -1);
            //아무것도 고르지 않은 경우의수 제거
        }
    }
}
