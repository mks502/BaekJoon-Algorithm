package problem.dynamic;

import java.io.*;

public class Main_11057 {
    static int[][] d ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        bw.write(Integer.toString(solve(num)));

        bw.flush();
        bw.close();
        br.close();
    }
    public static int solve(int n){
        int sum = 0;
        d = new int[n+1][10];
        init();

        for(int i = 2; i <= n; i++){
            for(int j = 0; j<10; j++){
                for(int k=0; k<=j; k++){
                    d[i][j] += d[i-1][k];
                }
                d[i][j] %= 10007;
            }
        }

        for(int i=0; i<10; i++) {
            sum += d[n][i];
        }

        return sum % 10007;
    }

    public static void init(){
        for(int i=0; i<10; i++){
            d[1][i] = 1;
        }
    }
}
