package problem.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1012 {
    public static int count;
    public static int m,n,k;
    public static boolean [][] visited;
    public static int [][] cabbage;
    public static int moveX[] = {0,0,-1,1};
    public static int moveY[] = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            count=0;
            String[] input = br.readLine().split(" ");
            m = Integer.parseInt(input[0]);
            n = Integer.parseInt(input[1]);
            k = Integer.parseInt(input[2]);
            visited = new boolean[n][m];
            cabbage = new int[n][m];

            for (int i = 0; i < k; i++) {
                String[] temp = br.readLine().split(" ");
                int y = Integer.parseInt(temp[0]);
                int x = Integer.parseInt(temp[1]);
                cabbage[x][y] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (cabbage[i][j] == 1 && visited[i][j]==false) {
                        bfs(i, j);
                    }
                }
            }
            bw.write(Integer.toString(count)+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static void bfs (int a, int b) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{a, b});
        visited[a][b] = true;

        while (!queue.isEmpty()){
            int coordinate[] = queue.poll();
            for(int i=0; i<4; i++) {
                int x = coordinate[0] + moveX[i];
                int y = coordinate[1] + moveY[i];

                if (x < 0 || y < 0 || x >= n || y >= m)
                    continue;
                if (!visited[x][y] && cabbage[x][y] == 1) {
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        count++;
    }
}