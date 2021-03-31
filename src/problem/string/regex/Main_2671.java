package problem.string.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main_2671 {

    static String str;

    public static void main(String[] args) throws IOException {
        input();
        String answer = solve(str);
        System.out.println(answer);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        br.close();
    }

    public static String solve(String input) {
        StringBuilder sb = new StringBuilder();
        String regex = "^(100+1+|01)+$";
        if(Pattern.matches(regex,input) == true){
            sb.append("SUBMARINE");
        }
        else
            sb.append("NOISE");

        return sb.toString();
    }
}