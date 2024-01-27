package P_1205;

public class Solution4 {
    public static boolean canGenerate(String s) {
        // 시작 문자열 "a"
        String current = "a";

        // 주어진 문자열 s의 길이
        int sLen = s.length();

        // 문자열을 생성하고 비교하기 위한 인덱스
        int currentIndex = 0;

        while (currentIndex < sLen) {
            int countA = 0;

            // 현재 문자열에서 'a'의 개수 세기
            for (char ch : current.toCharArray()) {
                if (ch == 'a') {
                    countA++;
                }
            }

            if(currentIndex + current.length() > sLen){
                break;
            }

            // 현재 문자열에 따라 다음 문자열 생성
            if ( current.equals(s.substring(currentIndex, currentIndex + current.length()))) {
                // 현재 문자열과 주어진 문자열 s의 일부가 일치하는 경우
                currentIndex += current.length();
            } else if (countA * 2 <= current.length()) {
                // 양 옆에 b 추가
                current = "b".repeat(countA) + current + "b".repeat(countA);
            } else {
                // 맨 앞 또는 맨 뒤에 a 추가
                current = "a" + current + "a";
            }
        }

        // 생성된 문자열과 주어진 문자열 s가 일치하는지 확인
        return currentIndex == sLen || current.equals(s);
    }

    public static boolean[] solution(String[] str) {
        int n = str.length;
        boolean[] result = new boolean[n];

        for (int i = 0; i < n; i++) {
            result[i] = canGenerate(str[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] str = {"abab", "bbaa", "aabaabaa"};
        boolean[] result = solution(str);

        for (boolean res : result) {
            System.out.println(res);
        }
    }
}