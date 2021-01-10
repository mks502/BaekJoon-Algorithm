package problem.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main_14501 {

    static int N;
    static int d[];
    static final int MAX = 5001;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        input();
        for(int i=1; i<=N; i++){
            System.out.println(d[i]);
        }
    }

    public void solve(){
//        for(int i=1; i<=N; i++){
//            if(d)
//        }
//        return d[N];
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        d = new int[N+1];
        for(int i=1; i<=N; i++){
            String temp[] = br.readLine().split(" ");
            int t = Integer.parseInt(temp[0]);
            int p = Integer.parseInt(temp[1]);

            if(i+t-1 > N){
                continue;
            }
            if(d[i] < d[i-1]){
                d[i] = d[i-1];
            }
            if( d[i+t-1] < d[i] + p ){
                d[i+t-1] = d[i] + p;
            }
        }
        br.close();
    }

}