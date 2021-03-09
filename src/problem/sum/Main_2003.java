package problem.sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2003 {
    static int n,m;
    static int numbers[];
    static int d[];
    static int count = 0;


    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(count);
    }

    public static void solve(){
        d[0] = numbers[0];
        for(int i=1; i<n; i++) {
            d[i] = d[i-1]+numbers[i];
        }
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(d[j]-d[i]+numbers[i] == m){
                    count++;
                }
            }
        }
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split( " ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        numbers = new int[n];
        d = new int[n];
        temp = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(temp[i]);
        }
    }

}
