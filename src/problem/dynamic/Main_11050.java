package problem.dynamic;

import java.io.*;

public class Main_11050 {
    static int n,k;
    static int d[][];
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input();
        int answer = combination(n,k);
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        k = Integer.parseInt(temp[1]);
        d = new int[n+1][k+1];
    }

    public static int combination (int n, int r){
        if(r == 0 || n == r){
            return 1;
        }
        else if(d[n][r] > 0)
            return d[n][r];
        return d[n][r] = combination(n-1,r-1) + combination(n-1,r);
    }
}
