package problem.dynamic;
import java.io.*;

public class Main_9465 {
    static int n;
    static int t;
    static int[][] d;
    static int sticker[][];
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        input();
        System.out.println(sb.toString());
        bw.flush();
        bw.close();
    }
    public static void solve() {
        d = new int[3][n+1];
        for (int i = 1; i <= n; i++) {
            d[0][i] += Math.max(d[1][i - 1], d[2][i - 1]);
            d[1][i] += Math.max(d[0][i - 1], d[2][i-1]) + sticker[1][i];
            d[2][i] += Math.max(d[0][i - 1], d[1][i-1]) + sticker[2][i];
        }
        int result = Math.max(d[0][n],d[1][n]);
        result = Math.max(result,d[2][n]);
        sb.append(result+"\n");
    }

    public static void input () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            n = Integer.parseInt(br.readLine());
            sticker = new int[3][n+1];
            for(int j=1; j<=2; j++){
                String[] in = br.readLine().split(" ");
                for(int k=1; k<in.length+1; k++){
                    sticker[j][k] = Integer.parseInt(in[k-1]);
                }
            }
            solve();
        }

        br.close();
    }
}
