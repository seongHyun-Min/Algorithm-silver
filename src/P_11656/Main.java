package P_11656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static ArrayList<String> result;

    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        result = new ArrayList<>();

        for(int i=0; i<S.length(); i++){
            result.add(S.substring(i, S.length()));
        }

        Collections.sort(result);

        for(String s : result){
            System.out.println(s);
        }
    }

}
