package problem.dynamic;

import java.io.*;

public class Main_1149 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer n = Integer.parseInt(br.readLine());
        int [][] d = new int [n+1][3];
        int [][] a = new int [n+1][3];
        int answer = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            String [] input = br.readLine().split(" ");
            for(int j=0; j<3; j++){
                a[i][j] = Integer.parseInt(input[j]);
            }
        }
        d[1][0] = a[1][0];
        d[1][1] = a[1][1];
        d[1][2] = a[1][2];
        for(int i=2; i<=n; i++){
            d[i][0] = Integer.min(d[i-1][1],d[i-1][2])+a[i][0];
            d[i][1] = Integer.min(d[i-1][0],d[i-1][2])+a[i][1];
            d[i][2] = Integer.min(d[i-1][0],d[i-1][1])+a[i][2];
        }
        answer = Math.min(d[n][0],Math.min(d[n][1],d[n][2]));

        bw.write(Integer.toString(answer));

        bw.flush();
        br.close();
        bw.close();
    }

}
