package problem.bfsdfs;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2206 {
    static int n,m;
    static boolean [][][] visited;
    static int [][] maze;
    static int moveX[] = {0,0,-1,1};
    static int moveY[] = {-1,1,0,0};
    static int distance[][];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input();
        solve();
        bw.flush();
        bw.close();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        visited = new boolean[n][m][2];
        maze = new int[n][m];
        distance = new int[n][m];

        for(int i=0; i<n; i++){
            String temp[] = br.readLine().split("");
            for(int j=0; j<m; j++){
                maze[i][j] = Integer.parseInt(temp[j]);
            }
        }
    }

    public static void solve () {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{0, 0,0});
        visited[0][0][0] = true;
        distance[0][0] = 1;

        while (!queue.isEmpty()){
            int coordinate[] = queue.poll();
            if(coordinate[0] == n-1 && coordinate[1] == m-1 ){
                System.out.println(distance[coordinate[0]][coordinate[1]]);
                return;
            }

            for(int i=0; i<4; i++){
                int x = coordinate[0] + moveX[i];
                int y = coordinate[1] + moveY[i];
                int num = coordinate[2];

                if ( x < 0 || y< 0 || x>=n || y>=m) {
                    continue;
                }

                if ( maze[x][y] == 1 ){
                    if( num==0 && !visited[x][y][1] ){
                        queue.offer(new int[]{x,y,1});
                        visited[x][y][1] = true;
                        distance[x][y] = distance[coordinate[0]][coordinate[1]] +1;
                    }
                }
                else {
                    if(visited[x][y][num]) {
                        continue;
                    }
                    queue.offer(new int[]{x,y,num});
                    visited[x][y][num] = true;
                    distance[x][y] = distance[coordinate[0]][coordinate[1]] +1;
                }
            }
        }
        System.out.println(-1);
    }
}