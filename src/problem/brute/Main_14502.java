package problem.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_14502 {
    static int n,m;
    static boolean [][] visited;
    static int [][] board;
    static boolean [][] targetVisited;
    static Queue<int[]> queue = new LinkedList();
    static int moveX[] = {0,0,-1,1};
    static int moveY[] = {-1,1,0,0};
    static int answer = Integer.MIN_VALUE;
    static List<int[]> virusList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        combination(0,0,0);
        System.out.println(answer);
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        visited = new boolean[n][m];
        board = new int[n][m];

        for(int i=0; i<n; i++){
            String temp[] = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(temp[j]);
                if(board[i][j] == 2){
                    virusList.add(new int[] {i,j});
                }
            }
        }
    }

    private static void combination(int depth,int r,int c){
        if(depth == 3){
            createBoard();
            return;
        }
        for(int i=r; i<n; i++){
            for(int j=c; j<m; j++){
                if(board[i][j] == 0 && !visited[i][j]){
                    visited[i][j] = true;
                    combination(depth+1,i,c);
                    visited[i][j] = false;
                }
            }
        }
    }

    private static void createBoard(){
        int tempBoard [][] = new int[n][m];
        targetVisited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]){
                    tempBoard[i][j] = 1;
                    continue;
                }
                tempBoard[i][j] = board[i][j];
            }
        }
        answer = Math.max(answer,bfs(tempBoard));
    }



    private static int bfs (int[][] target) {
        int count = 0;
        for(int num=0; num< virusList.size(); num++) {
            int position[] = virusList.get(num);
            targetVisited[position[0]][position[1]] = true;
            queue.offer(new int[]{position[0], position[1]});

            while (!queue.isEmpty()) {
                int coordinate[] = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = coordinate[0] + moveX[i];
                    int y = coordinate[1] + moveY[i];
                    if (x < 0 || y < 0 || x >= n || y >= m)
                        continue;
                    if(target[x][y] == 1)
                        continue;
                    if (target[x][y] == 0 && targetVisited[x][y] == false) {
                        queue.offer(new int[]{x, y});
                        targetVisited[x][y] = true;
                        target[x][y] = 2;
                    }
                }
            }
        }
        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if(target[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }
}