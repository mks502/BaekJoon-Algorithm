package problem.bfsdfs;

import java.io.*;

public class Main_10026 {
    static int n;
    static boolean [][] visited;
    static char [][] arr1;
    static char [][] arr2;
    static int moveX[] = {0,0,-1,1};
    static int moveY[] = {-1,1,0,0};
    static char currentColor;
    static int currentCount=0;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input();

        solve(arr1);
        solve(arr2);

        bw.flush();
        bw.close();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        arr1 = new char[n][n];
        arr2 = new char[n][n];

        for(int i=0; i<n; i++){
            String temp[] = br.readLine().split("");
            for(int j=0; j<n; j++){
                char currentChar = temp[j].charAt(0);
                arr1[i][j] = currentChar;
                if(currentChar == 'R'){
                    currentChar = 'G';
                }
                arr2[i][j] = currentChar;
            }
        }
        br.close();
    }

    public static void dfs(int x, int y, char[][] target){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int currentX = x+moveX[i];
            int currentY = y+moveY[i];

            if ( currentX < 0 || currentY< 0 || currentX>=n || currentY>=n)
                continue;

            if(currentColor == target[currentX][currentY] && !visited[currentX][currentY]){
                dfs(currentX,currentY,target);
            }
        }
    }

    public static void solve(char[][] target){
        currentCount = 0;
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    currentColor = target[i][j];
                    dfs(i,j,target);
                    currentCount++;
                }
            }
        }
        System.out.println(currentCount);
    }
}