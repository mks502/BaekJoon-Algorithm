package problem.dynamic;

import java.io.*;

public class Main_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int answer = solve(n);
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
    public static int solve(int n){
        int [] d = new int[1001];
        d[1] = 1;
        d[2] = 2;
        for(int i=3; i<=n; i++) {
            d[i] = d[i - 1] % 10007 + d[i - 2] % 10007;
        }
        return d[n] % 10007;
    }
}