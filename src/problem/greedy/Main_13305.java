package problem.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_13305 {

    static int N;
    static Long distance[];
    static Long value[];
    static Long min = Long.MAX_VALUE;
    static Long cost;

    public static void main(String[] args) throws IOException {
        input();
        Long result = solve();
        System.out.println(result);
    }

    public static Long solve(){
        cost = 0L;
        cost += (value[0] * distance[1]);
        min = value[0];
        for(int i=2; i<N; i++){
            min = Math.min(min,value[i-1]);
            cost += min * distance[i];
        }
        return cost;
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        distance = new Long [N];
        value = new Long [N];
        String in[] = br.readLine().split(" ");
        String in2[] = br.readLine().split(" ");
        for(int i=1; i<N; i++){
            distance[i] = Long.parseLong(in[i-1]);
        }
        for(int i=0; i<N; i++){
            value[i] = Long.parseLong(in2[i]);
        }
        br.close();
    }

}