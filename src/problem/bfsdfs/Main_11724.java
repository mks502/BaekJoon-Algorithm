package problem.bfsdfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11724 {
    static int N, M, answer;
    static boolean[] visit;
    static List<List<Integer>> adList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        adList = new ArrayList<>();
        for(int i=0; i<N+1; i++) {
            adList.add(new <Integer>ArrayList());
        }
        visit = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            String temp[] = br.readLine().split(" ");
            int u = Integer.parseInt(temp[0]);
            int v = Integer.parseInt(temp[1]);
            adList.get(u).add(v);
            adList.get(v).add(u);
        }
        answer = 0;
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                dfs(i);
                answer++;
            }
        }
        System.out.println(answer);
        br.close();
    }

    public static void bfs(int num){
        Queue<Integer> queue = new LinkedList<>();
        visit[num] = true;
        queue.add(num);

        while(!queue.isEmpty()){
            int current = queue.poll();
            for (int next : adList.get(current)) {
                if(visit[next]==true){
                    continue;
                }
                visit[next]=true;
                queue.add(next);
            }
        }
    }
    public static void dfs(int num){
        visit[num] = true;
        for(int next : adList.get(num)){
            if(visit[next]){
                continue;
            }
            dfs(next);
        }
    }
}
