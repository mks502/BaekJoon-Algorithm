package problem.dynamic;

import java.io.*;

public class Main_11048 {
    static int n;
    static int m;
    static int[][] area;
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input();
        solve();
        System.out.println(dp[n-1][m-1]);
        bw.flush();
        bw.close();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in[] = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);

        area = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            String temp[] = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(temp[j]);
                area[i][j] = num;
            }
        }
    }

    public static void solve() {
        dp[0][0] = area[0][0];
        for(int i=1; i<n; i++){
            dp[i][0] = dp[i-1][0] + area[i][0];
        }
        for(int i=1; i<m; i++){
            dp[0][i] = dp[0][i-1] + area[0][i];
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                int maxNum = Math.max(dp[i-1][j] , dp[i][j-1] );
                dp[i][j] = maxNum+area[i][j];
            }
        }
    }
}