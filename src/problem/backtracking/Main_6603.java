package problem.backtracking;

import java.util.Scanner;

public class Main_6603 {
    static boolean[] visited;
    static final int MAX = 6;
    static StringBuilder sb;
    static int lotto[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        while (true) {
            int n = sc.nextInt();
            if (n == 0)
                break;
            lotto = new int[n];
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                lotto[i] = sc.nextInt();
            }

            for (int i = 0; i < lotto.length; i++) {
                visited[i] = true;
                backTracking(i, 1, lotto[i] + " ");
                visited[i] = false;
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }


    public static void backTracking(int index, int count, String str) {
        if (count == MAX) {
            sb.append(str + "\n");
            return;
        }
        for (int i = index + 1; i < lotto.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            backTracking(i, count + 1, str + lotto[i] + " ");
            visited[i] = false;
        }
    }
}