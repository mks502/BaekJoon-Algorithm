package problem.shortest.Q1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main_1504 {

    static class Node implements Comparable<Node>{
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
    static int N, M, start,end;
    static List<List<Node>> adList;
    static int[] distance;
    static boolean[] visited;
    static PriorityQueue<Node> priorityQueue;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer[] = {0,0};

        String input[] = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        adList = new ArrayList<>();
        // 인덱스를 1부터 하기 위해서 한 개를 넣어둠
        adList.add(new <Node>ArrayList());
        for (int i = 1; i <= N; i++) {
            adList.add(new <Node>ArrayList());
        }

        for (int i = 0; i < M; i++) {
            String[] temp = br.readLine().split(" ");
            int u = Integer.parseInt(temp[0]);
            int v = Integer.parseInt(temp[1]);
            int cost = Integer.parseInt(temp[2]);
            adList.get(u).add(new Node(v, cost));
            adList.get(v).add(new Node(u, cost));
        }

        input = br.readLine().split(" ");
        int first = Integer.parseInt(input[0]);
        int second = Integer.parseInt(input[1]);

        answer[0] += solve(1,first)+solve(first,second)+solve(second,N);
        answer[1] += solve(1,second)+solve(second,first)+solve(first,N);

        int shortestPathCost = Integer.min(answer[0],answer[1]);
        if(shortestPathCost>=INF)
            System.out.println(-1);
        else
            System.out.println(shortestPathCost);
    }

    private static int solve(int start , int end) {
        priorityQueue = new PriorityQueue<>();
        visited = new boolean[N +1];
        distance = new int[N + 1];
        Arrays.fill(distance, INF);

        distance[start] = 0;
        priorityQueue.add(new Node(start, 0));

        while(!priorityQueue.isEmpty()) {
            Node current =  priorityQueue.poll();

            if(visited[current.index]){
                continue;
            }
            visited[current.index] = true;
            // 연결된 정점들을 확인
            for(Node destination : adList.get(current.index)) {
                //목적지 직행 , 현재까지 거리 + 현재에서 목적지 거리
                if(distance[destination.index] > distance[current.index] + destination.distance) {
                    // 최소 거리 비용 갱신
                    distance[destination.index] = distance[current.index] + destination.distance;
                    priorityQueue.add(new Node(destination.index, distance[destination.index]));
                }
            }
        }
        return distance[end];
    }
}
