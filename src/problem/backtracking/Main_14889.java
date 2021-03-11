package problem.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_14889 {

    static int sum[] = new int[2];
    static int n;
    static int[][] ability;
    static boolean [] visited;
    static int min = Integer.MAX_VALUE;
    static List<Integer>[] teamList = new List[2];

    public static void main(String[] args) throws IOException {
        input();
        dfs(1,1);
        System.out.println(min);
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ability = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            String temp[] = br.readLine().split( " ");
            for(int j=1; j<=n; j++){
                ability[i][j] = Integer.parseInt(temp[j-1]);
            }
        }
    }

    public static void dfs(int depth,int index) {
        if(min == 0){
            return;
        }
        if((n/2)+1==depth){
            divideTeam();
            caculate();
            return;
        }
        for(int i=index; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1,i);
                visited[i] = false;
            }
        }
    }

    public static void divideTeam(){
        teamList[0] = new ArrayList<Integer>();
        teamList[1] = new ArrayList<Integer>();
        for(int i=1; i<=n; i++) {
            if(visited[i]){
                teamList[0].add(i);
            }
            else
                teamList[1].add(i);

        }
    }
    public static void caculate(){
        for(int index=0; index<2; index++){
            sum[index] = 0;
            for(int i=0; i<teamList[index].size(); i++){
                int x = teamList[index].get(i);
                for(int j=0; j<teamList[index].size(); j++){
                    int y = teamList[index].get(j);
                    if(x==y){
                        continue;
                    }
                    sum[index] += ability[x][y];
                }
            }
        }
        int result = Math.abs(sum[0]-sum[1]);
        min = Math.min(min,result);
    }
}
