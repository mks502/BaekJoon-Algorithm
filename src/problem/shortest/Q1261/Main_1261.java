package problem.shortest.Q1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main_1261 {

    static int moveX[] = {0,0,-1,1};
    static int moveY[] = {-1,1,0,0};
    static int maze[][];
    static int distance[][];
    static int n,m;

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node target) {
            // 작은 거리 비용이 먼저 오도록
            return this.distance - target.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(distance[n-1][m-1]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split( " ");
        m= Integer.parseInt(temp[0]);
        n= Integer.parseInt(temp[1]);
        maze = new int[n][m];
        distance = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }

        for(int i=0; i<n; i++){
            temp = br.readLine().split("");
            for(int j=0; j<m; j++){
                maze[i][j] = Integer.parseInt(temp[j]);
            }
        }
        br.close();
    }
    private static void solve(){
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(0,0,0));
        distance[0][0] = 0;

        while (! priorityQueue.isEmpty()){
            Node currentNode = priorityQueue.poll();
            if(currentNode.x == n-1 && currentNode.y == m-1){
                return;
            }

            for(int i=0; i<4; i++){
                int x = currentNode.x +moveX[i];
                int y = currentNode.y + moveY[i];
                if(x < 0 || y <0 || x >= n || y >= m){
                    continue;
                }
                if(distance[x][y] > distance[currentNode.x][currentNode.y]+maze[x][y] ){
                    distance[x][y] = distance[currentNode.x][currentNode.y]+maze[x][y];
                    priorityQueue.add(new Node(x,y,distance[x][y]));
                }
            }
        }
    }
}