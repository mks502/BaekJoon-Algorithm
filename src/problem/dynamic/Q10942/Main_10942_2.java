package problem.dynamic.Q10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10942_2 {

    static int[] numbers;
    static int dp[][];
    static int n,m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(sb.toString());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String palindrome[] = br.readLine().split(" ");
        numbers = new int[n+1];
        dp = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            numbers[i] = Integer.parseInt(palindrome[i-1]);
        }
        solve();
        m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            String temp[] = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);
            sb.append(dp[start][end]+"\n");
        }
        br.close();
    }

    private static void solve() {
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        }

        for (int i = 1; i <= n - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                dp[i][i + 1] = 1;
            } else {
                dp[i][i + 1] = 0;
            }
        }


        for (int j = 3; j <= n; j++) {
            for (int i = 1; i <= j; i++) {
                if (dp[i][j] == 1 || j - i == 1) {
                    continue;
                }
                if (dp[i + 1][j - 1] == 1 && numbers[i] == numbers[j]) {
                    dp[i][j] = 1;
                }
            }
        }
    }
}