package problem.bfs;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2178 {
    public static int n,m;
    public static boolean [][] visited;
    public static int [][] maze;
    public static int moveX[] = {0,0,-1,1};
    public static int moveY[] = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input();
        int answer = solve();
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        visited = new boolean[n][m];
        maze = new int[n][m];

        for(int i=0; i<n; i++){
            String temp[] = br.readLine().split("");
            for(int j=0; j<m; j++){
                maze[i][j] = Integer.parseInt(temp[j]);
            }
        }
    }

    public static int solve () {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()){
            int coordinate[] = queue.poll();
            for(int i=0; i<4; i++){
                int x = coordinate[0] + moveX[i];
                int y = coordinate[1] + moveY[i];

                if ( x < 0 || y< 0 || x>=n || y>=m)
                    continue;
                if ( maze[x][y] == 0 || visited[x][y] == true)
                    continue;

                queue.offer(new int[]{x,y});
                maze[x][y] = maze[coordinate[0]][coordinate[1]] + 1;
                visited[x][y] = true;
            }
        }
        return maze[n-1][m-1];
    }
}