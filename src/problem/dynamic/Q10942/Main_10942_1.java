package problem.dynamic.Q10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10942_1 {

    static String palindrome;
    static int n,m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(sb.toString());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        palindrome = br.readLine().replaceAll(" ","");
        m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            String temp[] = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);

            if(end-start+1 == 2){
                sb.append(0);
                sb.append("\n");
                continue;
            }

            String subString = palindrome.substring(start-1,end);
            if (isPalindrome(subString) ){
                sb.append(1);
            }
            else
                sb.append(0);
            sb.append("\n");
        }
        br.close();
    }

    private static boolean isPalindrome(String str) {
        String reverseStr =  new StringBuilder(str).reverse().toString();
        if (str.equals(reverseStr))
            return true;
        else
            return false;
    }
}