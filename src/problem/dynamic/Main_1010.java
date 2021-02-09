package problem.dynamic;

import java.io.*;

public class Main_1010 {

    static int n,m;
    static int T;
    static StringBuilder sb;
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int i=0; i<T; i++){
            String[] temp = br.readLine().split(" ");
            n = Integer.parseInt(temp[0]);
            m = Integer.parseInt(temp[1]);
            dp = new int[m+1][n+1];
            sb.append(combination(m,n)+"\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static int combination(int n, int r) {
        if (n == r || r == 0)
            return 1;
        else if(dp[n][r] > 0)
            return dp[n][r];
        else
            return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }
}