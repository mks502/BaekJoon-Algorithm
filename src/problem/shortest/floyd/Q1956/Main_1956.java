package problem.shortest.floyd.Q1956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1956 {
    static int V ,E;
    static int[][] graph;
    static int INF = 1000000;
    static int min = INF;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        if(min==INF)
            System.out.println(-1);

        else
            System.out.println(min);
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        V = Integer.parseInt(temp[0]);
        E = Integer.parseInt(temp[1]);
        graph = new int[V + 1][V + 1];
        for(int i=0; i<graph.length; i++) {
            Arrays.fill(graph[i], INF);
        }
        for(int i = 0; i< E; i++){
            temp = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);
            int cost = Integer.parseInt(temp[2]);

            graph[start][end] = cost;
        }
        br.close();
    }

    private static void solve(){
        floyd();
        for(int i=1; i<=V; i++) {
            min = Math.min(min, graph[i][i]);
        }
    }

    private static void floyd() {
        for(int k = 1; k<= V; k++){
            for(int i = 1; i<= V; i++){
                for(int j = 1; j<= V; j++){
                    graph[i][j] = Math.min(graph[i][j],graph[i][k]+graph[k][j]);
                }
            }
        }
    }
}
