package problem.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992 {
    static int n;
    static int board[][];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        input();
        solve(0, 0, n);
        System.out.println(sb.toString());
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        br.close();
    }

    public static void solve(int startX, int startY, int len) {
        if (check(startX, startY, len)) {
            if (board[startY][startX] == 1) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        } else {
            int length = len / 2;
            sb.append("(");
            solve(startX, startY, length);
            solve(startX + length, startY, length);
            solve(startX, startY + length, length);
            solve(startX + length, startY + length, length);
            sb.append(")");
        }
    }

    public static boolean check(int startX, int startY, int len) {
        int color = board[startY][startX];
        for (int i = startY; i < startY + len; i++) {
            for (int j = startX; j < startX + len; j++) {
                if (color != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}