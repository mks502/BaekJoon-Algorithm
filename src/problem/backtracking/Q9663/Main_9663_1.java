package problem.backtracking.Q9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663_1 {
    static int N, ans;

    static boolean[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new boolean[N][N];
        ans = 0;
        solve(0);
        System.out.println(ans);
    }

    public static void solve(int r) {
        if (r == N) {
            ans++;
            return;
        }
        for (int c = 0; c < N; c++) {
            if (check(r, c)) {
                board[r][c] = true;
                solve(r + 1);
                board[r][c] = false;
            }
        }
    }

    public static boolean check(int r, int c) {
        if (board[r][c])
            return false;

        for (int i = 0; i < N; i++) {
            if (board[i][c])
                return false;
            for (int j = 0; j < N; j++) {
                if(Math.abs(r-i) == Math.abs(c-j) && board[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}