package problem.dynamic;

import java.io.*;

public class Main_2293 {
    static int n;
    static int k;
    static int dp[];
    static int coin[];
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input();
        solve();
        bw.flush();
        bw.close();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        coin = new int[n];
        dp = new int[k+1];
        for(int i=0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        br.close();
    }
    public static void solve() {
        dp[0] = 1;
        for (int i = 0; i <n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                dp[j] += dp[j-coin[i]];
            }
        }
        System.out.println(dp[k]);
    }

}
