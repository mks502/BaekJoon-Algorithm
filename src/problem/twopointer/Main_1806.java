package problem.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1806 {
    static int n, m;
    static int numbers[];
    static int start, end;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        if (min == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(min);
    }

    private static void solve() {
        int sum = 0;
        start = 0;
        end = 0;

        while (true) {
            if (sum >= m) {
                sum -= numbers[start++];
            } else if (end == n) {
                break;
            } else {
                sum += numbers[end++];
            }

            if (sum >= m) {
                min = Math.min(min, end - start);
            }
        }

    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        numbers = new int[n];
        temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(temp[i]);
        }
    }
}