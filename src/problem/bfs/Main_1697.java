package problem.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1697 {
    static int n, k;
    static boolean[] visited;
    static int[] position;
    static Queue<Integer> queue = new LinkedList();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input();
        int answer = bfs(n);
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        visited = new boolean[200001];
        position = new int[200001];

        br.close();
    }

    public static int bfs(int n) {
        queue.offer(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            int move = queue.poll();
            if(move * 2 > 200001)
                continue;

            if (move * 2 <= 200001 && !visited[move * 2]) {
                position[move * 2] = position[move] + 1;
                visited[move * 2] = true;
                queue.offer((move * 2));
            }

            if (move >= 1 && !visited[move - 1]) {
                position[move - 1] = position[move] + 1;
                visited[move - 1] = true;
                queue.offer((move - 1));
            }

            if (move <= 200000 && !visited[move + 1]) {
                position[move + 1] = position[move] + 1;
                visited[move + 1] = true;
                queue.offer((move + 1));
            }

            if (visited[k] == true) {
                return position[k];
            }
        }
        return -1;
    }
}