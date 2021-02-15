package problem.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_10988 {

    static String word;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        br.close();
    }

    public static void solve() {
        for(int i=0; i< word.length()/2; i++){
            if(word.charAt(i) != word.charAt(word.length()-1-i)){
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}