package problem.greedy;

import java.io.*;
import java.util.Arrays;

public class Main_1049 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] single = new int[m];
        int[] set = new int[m];
        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            set[i] = Integer.parseInt(input2[0]);
            single[i] = Integer.parseInt(input2[1]);
        }

        int answer = solve(n, set, single);
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
    public static int solve(int n, int[] set, int[] single) {
        Arrays.sort(set);
        Arrays.sort(single);
        return Math.min(Math.min(((n % 6) * single[0]) + ((n / 6) * set[0]), n * single[0]), ((n / 6) + 1) * set[0]);
    }
}