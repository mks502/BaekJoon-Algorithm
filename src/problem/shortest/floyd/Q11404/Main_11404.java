package problem.shortest.floyd.Q11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11404 {

    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];

        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            String input[] = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            graph[a][b] = Integer.min(graph[a][b], cost);
        }
        floyd();
        printAnswer();
    }

    private static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][k] == INF || graph[k][j] == INF) continue;

                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

    }

    private static void printAnswer() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] == INF)
                    System.out.print(0 + " ");
                else
                    System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

}
