package problem.shortest.Q9370;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main_9370 {

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node target) {
            // 작은 거리 비용이 먼저 오도록
            return this.distance - target.distance;
        }
    }

    static final int INF = 100000000;
    static int T, n, m, t;
    static int s, g, h;
    static List<List<Node>> adList;
    static int[] distance;
    static boolean[] visited;
    static PriorityQueue<Node> priorityQueue;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {


            String input[] = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            t = Integer.parseInt(input[2]);

            input = br.readLine().split(" ");
            s = Integer.parseInt(input[0]);
            g = Integer.parseInt(input[1]);
            h = Integer.parseInt(input[2]);

            adList = new ArrayList<>();
            // 인덱스를 1부터 하기 위해서 한 개를 넣어둠
            adList.add(new <Node>ArrayList());
            for (int i = 1; i <= n; i++) {
                adList.add(new <Node>ArrayList());
            }

            for (int i = 0; i < m; i++) {
                String[] temp = br.readLine().split(" ");
                int u = Integer.parseInt(temp[0]);
                int v = Integer.parseInt(temp[1]);
                int cost = Integer.parseInt(temp[2]);
                adList.get(u).add(new Node(v, cost));
                adList.get(v).add(new Node(u, cost));
            }


            PriorityQueue<Integer> answerQueue = new PriorityQueue<>();
            for (int i = 0; i < t; i++) {
                int destination = Integer.parseInt(br.readLine());

                int min = Math.min(dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, destination), dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, destination));
                int shortestPath = dijkstra(s, destination);
                if (shortestPath == min) {
                    answerQueue.add(destination);
                }
            }

            while (!answerQueue.isEmpty()) {
                sb.append(answerQueue.poll() + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int dijkstra(int start, int end) {
        priorityQueue = new PriorityQueue<>();
        visited = new boolean[n + 1];
        distance = new int[n + 1];
        Arrays.fill(distance, INF);

        distance[start] = 0;
        priorityQueue.add(new Node(start, 0));

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            if (visited[current.index]) {
                continue;
            }
            visited[current.index] = true;
            // 연결된 정점들을 확인
            for (Node destination : adList.get(current.index)) {
                //목적지 직행 , 현재까지 거리 + 현재에서 목적지 거리
                if (distance[destination.index] > distance[current.index] + destination.distance) {
                    // 최소 거리 비용 갱신
                    distance[destination.index] = distance[current.index] + destination.distance;
                    priorityQueue.add(new Node(destination.index, distance[destination.index]));
                }
            }
        }
        return distance[end];
    }
}
