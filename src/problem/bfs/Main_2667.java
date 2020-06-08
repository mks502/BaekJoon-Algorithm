package problem.bfs;
import java.io.*;
import java.util.*;

public class Main_2667 {
    public static int n;
    public static boolean [][] visited;
    public static int [][] house;
    public static int moveX[] = {0,0,-1,1};
    public static int moveY[] = {-1,1,0,0};
    public static ArrayList<Integer> houseCount = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(house[i][j] == 1 && !visited[i][j]){
                    bfs(i,j);
                }
            }
        }
        Collections.sort(houseCount);
        bw.write(Integer.toString(houseCount.size())+"\n");
        for(int i=0; i<houseCount.size(); i++){
            bw.write(Integer.toString(houseCount.get(i))+"\n");
        }
        bw.flush();
        bw.close();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        house = new int[n][n];

        for(int i=0; i<n; i++){
            String temp[] = br.readLine().split("");
            for(int j=0; j<n; j++){
                house[i][j] = Integer.parseInt(temp[j]);
            }
        }
        br.close();
    }

    public static void bfs (int a, int b) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{a, b});
        visited[a][b] = true;
        int count = 1;

        while (!queue.isEmpty()){
            int coordinate[] = queue.poll();
            for(int i=0; i<4; i++){
                int x = coordinate[0] + moveX[i];
                int y = coordinate[1] + moveY[i];

                if ( x < 0 || y< 0 || x>=n || y>=n)
                    continue;
                if ( house[x][y] == 0 || visited[x][y] == true)
                    continue;

                queue.offer(new int[]{x,y});
                visited[x][y] = true;
                count++;
            }
        }
        houseCount.add(count);
    }
}