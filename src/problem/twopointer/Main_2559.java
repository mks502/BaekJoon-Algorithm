package problem.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2559 {
    static int n, k;
    static int sequence[];
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(max);
    }

    public static void solve(){
        int sum = 0;
        for(int i=0; i<k; i++){
            sum += sequence[i];
        }
        max = Math.max(max,sum);
        for(int i=k; i<n; i++){
            sum -= sequence[i-k];
            sum += sequence[i];
            max = Math.max(max,sum);
        }
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split( " ");
        n = Integer.parseInt(temp[0]);
        k = Integer.parseInt(temp[1]);
        sequence = new int[n];
        temp = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            sequence[i] = Integer.parseInt(temp[i]);
        }
    }

}
