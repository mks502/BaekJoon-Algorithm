package problem.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main_14501 {

    static int N;
    static int t[];
    static int p[];
    static int max = -1;

    public static void main(String[] args) throws IOException {
        input();
        dfs(1,0);
        System.out.println(max);
    }

    public static void dfs(int index, int value) {
        if (index >= N+1) {
            max = Math.max(max,value);
            return;
        }
        if (index + t[index] <= N + 1) {
            dfs(index + t[index], value + p[index]);
        }
        dfs(index+1,value);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        t = new int[N+1];
        p = new int[N+1];
        for(int i=1; i<=N; i++){
            String temp[] = br.readLine().split(" ");
            t[i] = Integer.parseInt(temp[0]);
            p[i] = Integer.parseInt(temp[1]);
        }
        br.close();
    }

}