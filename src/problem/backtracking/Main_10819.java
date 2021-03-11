package problem.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10819 {

    static int n;
    static boolean[] visited;
    static int[] sequence,numbers;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        dfs (1);
        System.out.println(max);
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sequence = new int[n+1];
        numbers = new int [n+1];
        visited = new boolean[n+1];
        String [] temp = br.readLine().split(" ");
        for(int i=1; i<=n; i++){
            numbers[i] = Integer.parseInt(temp[i-1]);
        }
    }

    public static void dfs(int depth) {
        if(depth==n+1){
            caculate();
            return;
        }
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                sequence[depth] = numbers[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

    public static void caculate(){
        int sum = 0;
        for(int i=1; i<=n-1; i++){
            sum+= Math.abs(sequence[i]-sequence[i+1]);
        }
        max = Math.max(max,sum);
    }
}
