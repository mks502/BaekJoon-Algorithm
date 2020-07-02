package problem.bfsdfs;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main_7576 {
    static int n,m;
    static boolean [][] visited;
    static int [][] tomato;
    static Queue<int[]> queue = new LinkedList();
    static int moveX[] = {0,0,-1,1};
    static int moveY[] = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input();
        if(queue.isEmpty())
            bw.write(Integer.toString(-1));

        int day = bfs();
        if(checkAllTomato() == false)
            day = -1;

        bw.write(Integer.toString(day));

        bw.flush();
        bw.close();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        visited = new boolean[n][m];
        tomato = new int[n][m];

        for(int i=0; i<n; i++){
            String temp[] = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                tomato[i][j] = Integer.parseInt(temp[j]);
                if(tomato[i][j]==1)
                    queue.offer(new int[]{i,j});
            }
        }
    }

    public static int bfs () {
        int day = 1;
        while (!queue.isEmpty()){
            int coordinate[] = queue.poll();
            for(int i=0; i<4; i++){
                int x = coordinate[0] + moveX[i];
                int y = coordinate[1] + moveY[i];

                if ( x < 0 || y< 0 || x>=n || y>=m)
                    continue;
                if ( tomato[x][y] == -1 || visited[x][y] == true)
                    continue;

                if(tomato[x][y] == 0 && visited[x][y] == false) {
                    queue.offer(new int[]{x, y});
                    tomato[x][y] = tomato[coordinate[0]][coordinate[1]] + 1;
                    visited[x][y] = true;
                }
                day = Integer.max(tomato[x][y],day);
            }
        }
        return day-1;
    }
    public static boolean checkAllTomato() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(tomato[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}