package problem.dynamic;

import java.io.*;

public class Main_9251 {
    static int dp[][];
    static String word1;
    static String word2;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input();
        solve();
        bw.flush();
        bw.close();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word1 = br.readLine();
        word2 = br.readLine();
        dp = new int[word1.length()+1][word2.length()+1];
        br.close();
    }
    public static void solve() {
        for(int i = 0; i <= word1.length(); i++)
            dp[i][0] = 0;
        for(int i = 0; i <= word2.length(); i++)
            dp[0][i] = 0;

        for(int i=1; i<=word1.length(); i++){
            for(int j=1; j<=word2.length(); j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[word1.length()][word2.length()]);
    }
}
