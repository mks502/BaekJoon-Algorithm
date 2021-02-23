package problem.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1357 {

    static String x,y;

    public static void main(String[] args) throws IOException {
        input();
        String answer = solve(x,y);
        System.out.println(Integer.parseInt(answer));
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        x = temp[0];
        y = temp[1];
        br.close();
    }

    public static String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }

    public static String solve(String a, String b) {
       int temp = ( Integer.parseInt(reverse(a)) + Integer.parseInt(reverse(b)) );
       return reverse(Integer.toString(temp));
    }


}