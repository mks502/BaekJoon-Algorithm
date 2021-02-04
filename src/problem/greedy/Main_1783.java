package problem.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1783 {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        br.close();
    }

    public static int solve() {
        if (N == 1) {
            return 1;
        } else if (N == 2) {
            if (M > 8) {
                return 4;
            }
            return ((M + 1) / 2);
        } else {
            if (M > 6) {
                return M - 6 + 4;
            } else {
                return Math.min(M, 4);
            }
        }
    }
}