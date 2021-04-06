package problem.topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_2252 {
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static List<List<Integer>> adjList ;
    static int[] depth;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        depth = new int[n+1];
        adjList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            temp = br.readLine().split(" ");
            int u = Integer.parseInt(temp[0]);
            int v = Integer.parseInt(temp[1]);
            adjList.get(u).add(v);
            depth[v]++;
        }
        br.close();
    }

    private static void solve(){
        for(int i=1; i<=n; i++){
            if(depth[i]==0){
                queue.offer(i);
            }
        }
        while (! queue.isEmpty()){
            int current = queue.poll();
            sb.append(current+" ");
            for(int next : adjList.get(current)){
                depth[next]--;
                if(depth[next] == 0){
                    queue.offer(next);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
