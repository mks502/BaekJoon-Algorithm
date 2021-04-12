package problem.topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_1005 {
    static int t,n,k,w;
    static int time[];
    static List<List<Integer>> adjList;
    static int depth[];
    static int dp[];
    static Queue<Integer> queue;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(sb.toString());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t= Integer.parseInt(br.readLine());
        for(int i=0 ;i<t; i++){
            adjList = new ArrayList<>();
            String[] temp = br.readLine().split(" ");
            n = Integer.parseInt(temp[0]);
            k = Integer.parseInt(temp[1]);
            time = new int[n+1];
            depth = new int[n+1];
            dp = new int[n+1];
            temp = br.readLine().split(" ");

            for (int j=0; j<=n; j++){
                adjList.add(new ArrayList<>());
            }

            for(int j=1; j<=n; j++){
                time[j] = Integer.parseInt(temp[j-1]);
                dp[j] = time[j];
            }
            for(int j=1; j<=k; j++){
                temp = br.readLine().split( " ");
                int u = Integer.parseInt(temp[0]);
                int v = Integer.parseInt(temp[1]);
                adjList.get(u).add(v);
                depth[v]++;
            }
            w = Integer.parseInt(br.readLine());
            solve();
        }
        br.close();
    }

    private static void solve(){
        queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(depth[i] == 0){
                queue.offer(i);
            }
        }
        while (! queue.isEmpty()){
            int current = queue.poll();
            if(current == w) {
                sb.append(dp[w]+"\n");
                return;
            }
            for(int next : adjList.get(current)){
                depth[next]--;
                if(depth[next] == 0){
                    queue.offer(next);
                }
                dp[next] = Math.max(dp[next],dp[current]+time[next]);
            }
        }
    }
}
