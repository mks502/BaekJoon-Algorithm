package problem.bfsdfs;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2468 {
    static int n;
    static boolean[][] visited;
    static int[][] area;
    static int moveX[] = {0, 0, -1, 1};
    static int moveY[] = {-1, 1, 0, 0};
    static int max = 0;
    static int maxArea = 0;
    static int count =0;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input();
        for (int h = 0; h <= max; h++) {
            visited = new boolean[n][n];
            count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i < 0 || j < 0 || i >= n || j >= n)
                        continue;
                    if (area[i][j] <= h || visited[i][j] == true)
                        continue;
                    solve(i,j,h);
                }
            }
            maxArea = Math.max(maxArea,count);
        }
        System.out.println(maxArea);
        bw.flush();
        bw.close();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        area = new int[n][n];

        for (int i = 0; i < n; i++) {
            String temp[] = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int height = Integer.parseInt(temp[j]);
                area[i][j] = height;
                max = Math.max(max,height);
            }
        }
    }

    public static void solve(int a, int b, int h) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{a, b});
        visited[a][b] = true;

        while (!queue.isEmpty()) {
            int coordinate[] = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = coordinate[0] + moveX[i];
                int y = coordinate[1] + moveY[i];

                if (x < 0 || y < 0 || x >= n || y >= n)
                    continue;
                if (area[x][y] <= h || visited[x][y] == true)
                    continue;

                queue.offer(new int[]{x, y});
                visited[x][y] = true;
            }
        }
        count++;
    }
}