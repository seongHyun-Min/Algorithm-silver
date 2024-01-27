package P_6443;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Main {
    static HashSet<String> set;
    static int N;
    static char[] arr;
    static boolean[] visited;

    static int[] alpha;

    //set으로 중복제거시 메모리 초과


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String target = br.readLine();
            arr = target.toCharArray();
            set = new LinkedHashSet<>();
            visited = new boolean[target.length()];
            alpha = new int[26];
            //중복 갯수 누적
            for (int j = 0; j < arr.length; j++) {
                alpha[arr[j] - 'a']++;
            }
            Arrays.sort(arr);
            DFS(0, "");
            for (String s : set) {
                System.out.println(s);
            }
        }
    }

    static void DFS(int count, String tmp) {
        if (count == arr.length) {
            set.add(tmp);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    DFS(count + 1, tmp + arr[i]);
                    visited[i] = false;
                }
            }
        }
    }
}
