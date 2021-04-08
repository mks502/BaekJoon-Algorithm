package problem.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_10451 {
    static int count = 0;
    static int t,n;
    static List<List<Integer>> adjList;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        input();
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int num=0; num<t; num++){
            count = 0;
            adjList = new ArrayList<>();
            n = Integer.parseInt(br.readLine());
            visited = new boolean[n+1];
            for(int i=0; i<=n; i++){
                adjList.add(new ArrayList<>());
            }
            String temp[] = br.readLine().split(" ");
            for(int i=1; i<=n; i++){
                int v = Integer.parseInt(temp[i-1]);
                adjList.get(i).add(v);
            }
            for(int i=1; i<=n; i++){
                if(!visited[i]){
                    dfs(i);
                }
            }
            System.out.println(count);
         }
        br.close();
    }

    private static void dfs(int start){
        visited[start] = true;
        for(int next : adjList.get(start)){
            if( !visited[next] ){
                dfs(next);
            }
            else{
                count++;
                return;
            }
        }
    }
}
