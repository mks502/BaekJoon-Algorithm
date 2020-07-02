package problem.bfsdfs;
import java.util.*;

public class Main_4963 {
    static int count;
    static int w;
    static int h;
    static boolean[][] visited;
    static int[][] island;
    static int moveX[] = {0, 0, -1, 1, 1, 1, -1, -1};
    static int moveY[] = {-1, 1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();

            if (w == 0 && h == 0)
                break;

            island = new int[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    island[i][j] = sc.nextInt();
                }
            }

            count = 0;
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (island[i][j] == 1 && visited[i][j] == false)
                        dfs(i, j, ++count);
                }
            }
            System.out.println(count);
        }

        sc.close();
    }

    public static void dfs(int x, int y, int count) {
        visited[x][y] = true;

        for (int i = 0; i < moveX.length; i++) {
            int nx = x + moveX[i];
            int ny = y + moveY[i];
            if (0 <= nx && nx < h && 0 <= ny && ny < w) {
                if (island[nx][ny] == 1 && visited[nx][ny] == false) {
                    dfs(nx, ny, count);
                }
            }
        }
    }
}