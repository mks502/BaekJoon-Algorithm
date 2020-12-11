package problem.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839 {

    static int N;
    static int d[];
    static final int MAX = 5001;

    public static void main(String[] args) throws IOException {
        input();
        int result = solve();
        if(result==MAX){
            result= -1;
        }
        System.out.println(result);
    }

    public static int solve(){
        for(int i=0; i<=N; i++){
            d[i] = MAX;
        }
        d[3] = 1;
        d[5] = 1;
        for(int i=5; i<=N; i++){
            if(d[i-3]== MAX && d[i-5]== MAX) {
                continue;
            }
            d[i] = Math.min(d[i-3],d[i-5])+1;
        }
        return d[N];
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        d = new int[MAX];
        br.close();
    }

}