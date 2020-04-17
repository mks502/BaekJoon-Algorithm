package problem.dynamic;
        import java.io.*;

public class Main_2193 {
    public static long[][] d = new long[91][2];
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long answer = solve(n);
        bw.write(Long.toString(answer));
        bw.flush();
        bw.close();
    }

    public static long solve(int n){
        d[1][1] = 1;
        for(int i=2; i<=n; i++){
            d[i][0] = d[i-1][1]+d[i-1][0];
            d[i][1] = d[i-1][0];
        }
        return d[n][0] + d[n][1];
    }
}
