package problem.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839 {

    static int N;

    public static void main(String[] args) throws IOException {
        input();
        int result = solve();
        System.out.println(result);
    }

    public static int solve(){
        int sugar = N;
        int num = 0;
        while(sugar>0){
            if(sugar%5 == 0){
                num += sugar/5;
                sugar %= 5;
            }
            else{
                sugar-=3;
                num++;
            }
        }
        if(sugar<0){
            return -1;
        }
        return num;
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();
    }

}