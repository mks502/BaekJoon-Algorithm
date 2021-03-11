package problem.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15650 {

    static int n,m;
    static boolean[] visited;
    static int[] sequence;

    public static void main(String[] args) throws IOException {
        input();
        dfs(1, 1);
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        sequence = new int[m+1];
        visited = new boolean[n+1];
    }

    public static void dfs(int index, int depth) {
        if(depth == m+1){
            print();
            return;
        }
        for(int i=index; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                sequence[depth] = i;
                dfs(i,depth+1);
                visited[i] = false;
            }
        }
    }

    public static void print(){
        for(int i=1; i<=m; i++){
            System.out.print(sequence[i]+" ");
        }
        System.out.println();
    }
}
