package problem.dynamic;

import java.io.*;

public class Main_1003 {
    static long d[][] = new long[42][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int input[] = new int[num];
        solve();
        for(int i=0; i<num; i++){
            int n = Integer.parseInt(br.readLine());
            if(i!=num-1)
                bw.write(Long.toString(d[n][0])+" "+Long.toString(d[n][1])+"\n");
            else
                bw.write(Long.toString(d[n][0])+" "+Long.toString(d[n][1]));
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static void solve(){
        d[0][0] = 1;
        d[0][1] = 0;
        d[1][0] = 0;
        d[1][1] = 1;
        for(int i=2; i<=41; i++){
            d[i][0] = d[i-2][0]+d[i-1][0];
            d[i][1] = d[i-2][1]+d[i-1][1];
        }
    }
}
