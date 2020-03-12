package problem.dynamic;

import java.io.*;

public class Main_1309 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer n = Integer.parseInt(br.readLine());
        int [][] d = new int [n+1][3];
        d[1][0]=1;
        d[1][1]=1;
        d[1][2]=1;
        for(int i=2; i<=n; i++){
            d[i][0] = (d[i-1][0] + d[i-1][1] + d[i-1][2]) %9901 ;
            d[i][1] = (d[i-1][0] + d[i-1][2]) %9901;
            d[i][2] = (d[i-1][0] + d[i-1][1]) %9901;
        }
        int answer = d[n][0] + d[n][1] + d[n][2];

        bw.write(Integer.toString(answer%9901));

        bw.flush();
        br.close();
        bw.close();
    }

}
