package P_1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String target;

    static String word;

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = br.readLine();
        word = br.readLine();
        count = 0;


        for (int i = 0; i <= target.length() - word.length(); ) {
            if (target.charAt(i) == word.charAt(0)) {
                //시작이 같으면 탐색
                String result = target.substring(i, i + word.length());
                if(result.equals(word)){
                    count ++;
                    i += word.length();
                }else{
                    i++; //다르면 하나 올리고
                }
            }else i++; //시작이 달라도 하나
        }
        System.out.println(count);

    }
}
