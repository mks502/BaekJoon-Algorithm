package problem.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1715 {
    static int N;
    static int[] cards;
    static PriorityQueue<Integer> priorityQueue;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(br.readLine());
            priorityQueue.add(cards[i]);
        }
        br.close();
    }

    public static int solve() {
        int answer = 0;
        if (N == 1) {
            return 0;
        }
        while (!priorityQueue.isEmpty()) {
            int temp = priorityQueue.poll() + priorityQueue.poll();
            answer += temp;
            if (!priorityQueue.isEmpty()) {
                priorityQueue.add(temp);
            }
        }
        return answer;
    }
}