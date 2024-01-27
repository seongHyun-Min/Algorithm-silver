import java.io.*;
import java.util.*;
class Main {
    static int W;
    static double R;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        R = Double.parseDouble(st.nextToken());

        double tmp = 1 + (R /30);
        result = (int) (W * tmp);
        System.out.println(result);
    }
}