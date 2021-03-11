package problem.backtracking.Q9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663_2 {
    static int N, ans;
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];
        ans = 0;
        solve(0);

        System.out.println(ans);
    }

    public static void solve(int row) {
        if(N==row){
            ans++;
            return;
        }
        for(int i=0; i<N; i++){
            board[row] = i;
            if(check(row)){
                solve(row+1);
            }
        }
    }

    public static boolean check(int row) {
        for(int i=0; i<row; i++){
            if(board[i] == board[row] || Math.abs(board[i]- board[row]) == Math.abs(i-row)){
                return false;
            }
        }
        return true;
    }
}