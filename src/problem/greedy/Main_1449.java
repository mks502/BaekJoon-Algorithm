package problem.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1449 {

    static int N;
    static int L;
    static int[] position;
    static int count = 0;
    static int current = 0;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        position = new int[N];
        String in[] = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            position[i] = Integer.parseInt(in[i]);
        }
        br.close();
    }

    public static void solve() {
        Arrays.sort(position);

        for (int i = 0; i < N; i++) {
            if (position[i] > current) {
                current = position[i] + L - 1;
                count++;
            }
        }
        System.out.println(count);

    }
}