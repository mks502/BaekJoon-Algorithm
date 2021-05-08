package problem.dynamic;

import java.io.*;

public class Main_2096 {
    static int n;
    static int[][] d;
    static int [][] board;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input();
        maxSolve();
        minSolve();
        bw.flush();
        bw.close();
    }

    public static void maxSolve() {
        for(int i=1; i<=n; i++){
            d[i][1] = Math.max(d[i][1], d[i-1][1]+board[i][1] );
            d[i][1] = Math.max(d[i][1], d[i-1][2]+board[i][1] );

            d[i][2] = Math.max(d[i][2], d[i-1][1]+board[i][2] );
            d[i][2] = Math.max(d[i][2], d[i-1][2]+board[i][2] );
            d[i][2] = Math.max(d[i][2], d[i-1][3]+board[i][2] );

            d[i][3] = Math.max(d[i][3], d[i-1][2]+board[i][3] );
            d[i][3] = Math.max(d[i][3], d[i-1][3]+board[i][3] );
        }
        int max = Math.max(d[n][1],d[n][2]);
        max = Math.max(max,d[n][3]);
        System.out.println(max);
    }

    public static void minSolve() {
        for(int i=1; i<=n; i++){
            d[i][1] = Math.min(d[i][1], d[i-1][1]+board[i][1] );
            d[i][1] = Math.min(d[i][1], d[i-1][2]+board[i][1] );

            d[i][2] = Math.min(d[i][2], d[i-1][1]+board[i][2] );
            d[i][2] = Math.min(d[i][2], d[i-1][2]+board[i][2] );
            d[i][2] = Math.min(d[i][2], d[i-1][3]+board[i][2] );

            d[i][3] = Math.min(d[i][3], d[i-1][2]+board[i][3] );
            d[i][3] = Math.min(d[i][3], d[i-1][3]+board[i][3] );
        }
        int min = Math.min(d[n][1],d[n][2]);
        min = Math.min(min,d[n][3]);
        System.out.println(min);
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d = new int[n + 1][4];
        board = new int[n+1][4];
        for(int i=1; i<=n; i++){
            String temp[] = br.readLine().split(" ");
            for(int j=1; j<=3; j++){
                board[i][j] = Integer.parseInt(temp[j-1]);
            }
        }
        br.close();
    }
}
