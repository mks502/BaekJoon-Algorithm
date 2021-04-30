package problem.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1780 {
    static int n;
    static int paper[][];
    static int minusOne = 0;
    static int zero = 0;
    static int plusOne = 0;

    public static void main(String[] args) throws IOException {
        input();
        solve(0, 0, n);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(plusOne);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(input[j]);
            }
        }

        br.close();
    }

    private static void solve(int startX, int startY, int len) {
        if (check(startX, startY, len)) {
            if (paper[startY][startX] == 1) {
                plusOne++;
            } else if (paper[startY][startX] == 0) {
                zero++;
            } else {
                minusOne++;
            }
        } else {

            int length = len / 3;
            solve(startX, startY, length);
            solve(startX, startY + length, length);
            solve(startX, startY + (2 * length), length);

            solve(startX + length, startY, length);
            solve(startX + length, startY + length, length);
            solve(startX + length, startY + (2 * length), length);

            solve(startX + (2 * length), startY, length);
            solve(startX + (2 * length), startY + length, length);
            solve(startX + (2 * length), startY + (2 * length), length);
        }
    }

    public static boolean check(int startX, int startY, int len) {
        int number = paper[startY][startX];
        for (int i = startY; i < startY + len; i++) {
            for (int j = startX; j < startX + len; j++) {

                if (number != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}