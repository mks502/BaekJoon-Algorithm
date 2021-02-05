package problem.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_2606 {
    static int N, M;
    static boolean[] visit;
    static List<List<Integer>> adList;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adList = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
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

        dfs(1);

        System.out.println(count);
        br.close();
    }

    public static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        visit[num] = true;
        queue.add(num);

        while (!queue.isEmpty()) {
            int currentNum = queue.poll();
            for (int i : adList.get(currentNum)) {
                if (visit[i] == false) {
                    visit[i] = true;
                    queue.add(i);
                    count++;
                }
            }
        }
    }

    public static void dfs(int num) {
        visit[num] = true;

        for (int i : adList.get(num)) {
            if (visit[i] == false) {
                dfs(i);
                count++;
            }
        }

    }
}
