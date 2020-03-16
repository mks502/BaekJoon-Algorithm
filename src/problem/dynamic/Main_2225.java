package problem.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2225 {
    public static void main(String[] args) throws IOException {
        long mod = 1000000000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [][] d = new int [k+1][n+1];
        d[0][0] = 1;
        for(int i=1; i<=k; i++){
            for(int j=0; j<=n; j++){
                for(int l=0; l<=j; l++){
                    d[i][j] += d[i-1][j-l];
                    d[i][j] %= mod;
                }
            }
        }
        bw.write(Integer.toString(d[k][n]));


        bw.flush();
        bw.close();
        br.close();
    }
}
