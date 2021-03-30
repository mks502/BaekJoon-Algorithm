package problem.string.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main_9342 {

    static String[] strs;
    static int n;

    public static void main(String[] args) throws IOException {
        input();
        String answer = solve();
        System.out.println(answer);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        strs = new String[n];
        for(int i=0; i<n; i++){
            strs[i] = br.readLine();
        }
        br.close();
    }

    public static String solve() {
        StringBuilder sb = new StringBuilder();
        String regex = "^[A-F]?A+F+C+[A-F]?$";
        for(int i=0; i<n; i++) {
            if( Pattern.matches(regex, strs[i]) == true){
                sb.append("Infected!\n");
            }
            else {
                sb.append("Good\n");
            }
        }
        return sb.toString();
    }
}