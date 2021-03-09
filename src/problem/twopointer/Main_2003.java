package problem.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2003 {
    static int n,m;
    static int numbers[];
    static int count = 0;


    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(count);
    }

    public static void solve(){
        int p1,p2;
        int sum = 0;
        p1 = 0;
        p2 = 0;

        while (true){
            if(sum >= m){
                sum -= numbers[p1++];
            }
            else if(p2 == n){
                break;
            }
            else {
                sum+= numbers[p2++];
            }
            if(sum == m){
                count++;
            }
        }

    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split( " ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        numbers = new int[n];
        temp = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(temp[i]);
        }
    }

}
