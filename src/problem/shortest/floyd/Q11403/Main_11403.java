package problem.shortest.floyd.Q11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11403 {
    static int N;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        input();
        floyd();
        print();
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        for(int i=0; i<N; i++){
            String temp[] = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(temp[j]);
            }
        }
        br.close();
    }

    private static void floyd() {
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if( graph[i][k] == 1 && graph[k][j] == 1){
                        graph[i][j] = 1;
                    }
                }
            }
        }
    }

    private static void print(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }


}
