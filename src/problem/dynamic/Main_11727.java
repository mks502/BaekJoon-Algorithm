package problem.dynamic;

import java.io.*;

public class Main_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        bw.write(Integer.toString(tiling(num)));

        bw.flush();
        bw.close();
        br.close();
    }
    static int[] d = new int[10000001];
    public static int tiling(int n){

        if(d[n]>0)
            return d[n];
        if(n<=1){
            d[n] = 1;
        }
        else {
            d[n] = (tiling(n - 1) + tiling(n - 2)*2) % 10007 ;
        }
        return d[n];
    }
}
