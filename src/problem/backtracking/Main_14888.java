package problem.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_14888 {

    static int n;
    static int[] numbers;
    static int[] operators;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        go(1, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        operators = new int[4];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            int count = Integer.parseInt(temp[i]);
            operators[i] = count;
        }
    }

    public static void go(int index, int number) {
        if (index == n) {
            max = Math.max(max, number);
            min = Math.min(min, number);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                if (i == 0) {
                    go(index + 1, number + numbers[index]);
                }
                if (i == 1) {
                    go(index + 1, number - numbers[index]);
                }
                if (i == 2) {
                    go(index + 1, number * numbers[index]);
                }
                if (i == 3) {
                    go(index + 1, number / numbers[index]);
                }
                operators[i]++;
            }
        }
    }
}
