package problem.queue;
import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_2164 {
    static int n;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        input();
        int answer = solve();
        System.out.println(answer);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        queue = new LinkedList<>();
    }

    public static int solve() {
        for(int i=1; i<=n; i++){
            queue.add(i);
        }

        while (queue.size()!=1){
            queue.poll();
            int card = queue.poll();
            queue.add(card);
        }
        return queue.poll();
    }
}