package P_21314;

import java.util.*;
class Solution {
    public static List<Integer> solution(int n, int m) {
        List<Integer> arr = new ArrayList<>();
        int gcd = GCD(n, m);
        System.out.println("gcd = " + gcd);
        arr.add(gcd);
        arr.add(n * m / gcd);
        return arr;
    }

    static int GCD(int a, int b){
        System.out.println("b = " + b);
        System.out.println("a = " + a);
        if(b !=0){
             GCD(b, a % b);
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 5));
    }
}