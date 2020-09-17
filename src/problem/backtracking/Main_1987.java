package problem.backtracking;

import java.util.Scanner;

public class Main_1987 {
    static int count;
    static int r;
    static int c;
    static int max;
    static boolean[] alphabet;
    static char[][] board;
    public static int moveX[] = {0,0,-1,1};
    public static int moveY[] = {-1,1,0,0};

    public static void main(String[] args) {
        max = Integer.MIN_VALUE;
        Scanner sc = new Scanner(System.in);
        String input[] = sc.nextLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        board = new char[r][c];
        alphabet = new boolean[26];
        for (int i = 0; i < r; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = temp.charAt(j);
            }
        }

        count = 0;
        int index = board[0][0] - 'A';
        dfs(0,0,index);
        System.out.println(max);

        sc.close();
    }

    public static void dfs(int x, int y, int ind) {
        alphabet[ind] = true;
        ++count;
        if(max < count){
            max = count;
        }

        for (int i = 0; i < moveX.length; i++) {
            int nx = x + moveX[i];
            int ny = y + moveY[i];

            if (0 <= nx && nx < r && 0 <= ny && ny < c) {
                char alpha = board[nx][ny];
                int index = alpha - 'A';
                if (alphabet[index]==false ) {
                    dfs(nx, ny, index);
                }
            }
        }
        alphabet[ind] = false;
        count--;
    }
}