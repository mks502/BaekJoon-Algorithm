package problem.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1316 {

    static int N;
    static String[] words;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(count);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        br.close();
    }

    public static void solve() {
        for (int i = 0; i < words.length; i++) {
            Set<Character> set = new HashSet<>();
            boolean isGroupWord = true;
            for (int j = 0; j < words[i].length(); j++) {
                char currentChar = words[i].charAt(j);
                if(j==0){
                    set.add(currentChar);
                    continue;
                }

                if(!set.contains(currentChar)){
                    set.add(currentChar);
                }
                else{
                    if(currentChar != words[i].charAt(j-1)){
                        isGroupWord = false;
                        break;
                    }
                }
            }
            if(isGroupWord){
                count++;
            }
        }
    }
}