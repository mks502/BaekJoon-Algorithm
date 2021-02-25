package problem.dynamic;

import java.io.*;

public class Main_1699 {
    static int n;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input();
        solve();
        bw.write(Integer.toString(d[n]));
        bw.flush();
        bw.close();
    }

    public static void solve() {
        d[1] = 1;
        for(int i=2; i<=n; i++){
            d[i] = i;
            for(int j=1; j*j<=i; j++){
                d[i] = Math.min(d[i],d[i-(j*j)]+1);
            }
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        br.close();
    }
}
