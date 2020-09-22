package problem.brute;

import java.io.*;

public class Main_1018 {
    static char[][] board;
    static int m,n;
    static int min;

    static final char[][] white = { // (0,0)이 W인 경우
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'}
    };

    static final char[][] black = { // (0,0)이 B인 경우
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
    };

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        min = Integer.MAX_VALUE;
        input();
        bw.write(Integer.toString(solve()));
        bw.flush();
        bw.close();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        board = new char[n][m];
        for(int i=0; i<n; i++){
            String temp = br.readLine();
            for(int j=0; j<m; j++){
                board[i][j] = temp.charAt(j);
            }
        }
    }

    public static int solve (){
        for(int i=0; i<=n-8; i++){
            for(int j=0; j<=m-8; j++){
                int whiteStartCount=0;
                int blackStartCount=0;

                for(int a=i , x=0; a<i+8; a++, x++){
                    for(int b=j , y =0; b<j+8; b++, y++){
                        if(board[a][b] != black[x][y] ){
                            blackStartCount++;
                        }
                        if(board[a][b] != white[x][y] ){
                            whiteStartCount++;
                        }
                    }
                }
                int count = Integer.min(blackStartCount,whiteStartCount);
                min = Integer.min(min,count);
            }
        }
        return min;
    }
}
