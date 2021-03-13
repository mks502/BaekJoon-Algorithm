package problem.backtracking;

import java.util.Scanner;

public class Main_6603_2 {
    static boolean[] visited;
    static final int MAX = 6;
    static StringBuilder sb;
    static int lotto[];
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        while (true) {
            n = sc.nextInt();
            if (n == 0)
                break;
            lotto = new int[n];
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                lotto[i] = sc.nextInt();
            }
            dfs(0,0);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void dfs(int depth,int index){
        if(MAX == depth){
            print();
            return;
        }
        for(int i=index; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1,i);
                visited[i] = false;
            }
        }
    }

    public static void print(){
        for(int i=0; i<n; i++ ){
            if(visited[i]){
                sb.append(lotto[i]+" ");
            }
        }
        sb.append("\n");
    }
}