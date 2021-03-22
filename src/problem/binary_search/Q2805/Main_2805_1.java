package problem.binary_search.Q2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_2805_1 {
    static int n, m;
    static int trees[];
    static int max = Integer.MIN_VALUE;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        trees = new int[n];
        temp = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            trees[i] = Integer.parseInt(temp[i]);
            max = Math.max(max,trees[i]);
        }
        br.close();
    }

    private static void solve(){
        for(int h=0; h<max; h++){
            int sum=0;
            for(int i=0; i<n; i++){
                if(trees[i] > h) {
                    sum += trees[i] - h;
                }
            }
            if(sum >= m) {
                answer = Math.max(answer, h);
            }
        }
    }
}
