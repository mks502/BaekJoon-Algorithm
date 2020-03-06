package problem.dynamic;

import java.io.*;

public class Main_10844 {
    public static int mod = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        bw.write(Long.toString(numberOfStairs(num)));
        bw.flush();
        bw.close();
        br.close();
    }
    public static int [][] d = new int[1000001][10];

    public static long numberOfStairs(int n){
        long result = 0;
        for(int i=1; i<=9; i++){
            d[1][i] = 1;
        }
        for(int i=2; i<=n; i++){
            for(int j=0; j<=9; j++){
                d[i][j] = 0;
                if(j-1>=0){
                    d[i][j] += d[i-1][j-1];
                }
                if(j+1<=9){
                    d[i][j] += d[i-1][j+1];
                }
                d[i][j] %= mod;
            }
        }
        for(int i=0; i<=9; i++){
            result+=d[n][i];
        }
        return result%mod;
    }

}
