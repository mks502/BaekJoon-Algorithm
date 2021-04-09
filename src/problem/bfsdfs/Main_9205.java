package problem.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_9205 {
    static StringBuilder sb = new StringBuilder();
    static final int INF = 10000;
    static boolean[] visited;
    static int position[][];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; tc++){
            n = Integer.parseInt(br.readLine());
            position = new int[n+2][2];
            visited = new boolean[n+2];
            for(int i=0; i<position.length; i++){
                Arrays.fill(position[i],INF);
            }
            for(int i=0; i<n+2; i++){
                String temp[] = br.readLine().split( " ");
                position[i][0] = Integer.parseInt(temp[0]);
                position[i][1] = Integer.parseInt(temp[1]);
            }
            bfs(0,n+1);
        }
        System.out.print(sb.toString());
        br.close();
    }

    private static void bfs(int start,int end){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()){
            int current = queue.poll();
            int x = position[current][0];
            int y = position[current][1];
            if(current == end){
                sb.append("happy\n");
                return;
            }
            for(int i=1; i<n+2; i++){
                if( !visited[i] && ( Math.abs(x-position[i][0]) + Math.abs(y-position[i][1]) <= 1000) ){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        sb.append("sad\n");
    }
}
