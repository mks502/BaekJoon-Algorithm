package problem.dynamic;

import java.io.*;

public class Main_17404 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer n = Integer.parseInt(br.readLine());
        int [][] d = new int [n+1][3];
        int [][] a = new int [n+1][3];
        int answer = 1000*1000 + 1;
        for(int i=1; i<=n; i++){
            String [] input = br.readLine().split(" ");
            for(int j=0; j<3; j++){
                a[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int j=0; j<3; j++) {
            for(int k=0; k<3; k++) {
                if(j==k)
                    d[1][k] = a[1][k];
                else
                    d[1][k] = 1000*1000 + 1;
            }
            for (int i = 2; i <= n; i++) {
                d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + a[i][0];
                d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + a[i][1];
                d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + a[i][2];
            }

            for(int k=0; k<3; k++) {
                if(j==k)
                    continue;
                else{
                    answer = Math.min(answer, d[n][k]);
                }
            }

        }
        bw.write(Integer.toString(answer));

        bw.flush();
        br.close();
        bw.close();
    }

}
