package problem.dynamic;
import java.io.*;

public class Main_2156 {
    public static int n;
    public static long[] d;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int wine[] = input();

        for (int i = 1; i <= n; i++) {
            if (i <= 2) {
                d[i] = d[i - 1] + wine[i];
                continue;
            }
            d[i] = d[i - 1];
            d[i] = Math.max(d[i], d[i - 2] + wine[i]);
            d[i] = Math.max(d[i], d[i - 3] + wine[i - 1] + wine[i]);
        }
        bw.write(Long.toString(d[n]));
        bw.flush();
        bw.close();
    }

    public static int[] input () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d = new long[n+1];
        int wine[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        return wine;
    }
}
