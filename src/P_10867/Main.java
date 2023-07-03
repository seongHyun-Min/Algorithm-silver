package P_10867;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    //순서를 보장해야되기 때문에 LinkedHashSet 사용
    static LinkedHashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        set = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); //오름차순 정렬


        for (int i = 0; i < N; i++) {
            set.add(arr[i]);
        }

        for(int num : set){
            System.out.print(num + " ");
        }

    }

}
