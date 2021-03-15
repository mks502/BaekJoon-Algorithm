package problem.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2630 {
    static int n;
    static int paper[][];
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        input();
        solve(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void input() throws IOException {
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

    public static void solve(int startX, int startY, int len) {
        if (check(startX, startY, len)) {
            if (paper[startY][startX] == 1) {
                blue++;
            } else {
                white++;
            }
        } else {
            int length = len / 2;
            solve(startX, startY, length);
            solve(startX + length, startY, length);
            solve(startX, startY + length, length);
            solve(startX + length, startY + length, length);
        }
    }

    public static boolean check(int startX, int startY, int len) {
        int color = paper[startY][startX];
        for (int i = startY; i < startY + len; i++) {
            for (int j = startX; j < startX + len; j++) {

                if (color != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}