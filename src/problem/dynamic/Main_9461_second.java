package problem.dynamic;
import java.io.*;

public class Main_9461_second {
    public static int n;
    public static long[] d = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input[] = input();
        solve();
        for (int i = 1; i <= n; i++) {
            bw.write(Long.toString(d[input[i]]));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void solve() {
        for (int i = 1; i <= 100; i++) {
            if (i < 4) {
                d[i] = 1;
                continue;
            }
            d[i] = d[i - 3] + d[i - 2];
        }
    }

    public static int[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int numbers[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        return numbers;
    }
}