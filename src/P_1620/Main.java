package P_1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static HashMap<String, Integer> map;
    static int N, M;

    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        arr = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            String target = br.readLine();
            map.put(target, i);
            arr[i] = target;
        }
        for (int i = 0; i < M; i++) {
            String find = br.readLine();
            //숫자인지 확인
            if (find.charAt(0) - '0' > 0 && find.charAt(0) - '0' <= 9) {
                int num = Integer.parseInt(find);
                System.out.println(arr[num]);
            } else {
                System.out.println(map.get(find));
            }
        }
    }
}
