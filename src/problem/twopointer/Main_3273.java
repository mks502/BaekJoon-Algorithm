package problem.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3273 {
    static int n,x;
    static int sequence[];
    static int count = 0;


    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(count);
    }

    public static void solve(){
        int start = 0;
        int end = n-1;
        Arrays.sort(sequence);
        while (start < end){
            int sum = sequence[start]+sequence[end];
            if(sum == x){
                start ++;
                end --;
                count++;
            }
            else if(sum < x ){
                start++;
            }
            else{
                end--;
            }
        }
    }


    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sequence = new int[n];
        String temp[] = br.readLine().split( " ");
        for(int i=0; i<n; i++){
            sequence[i] = Integer.parseInt(temp[i]);
        }
        x = Integer.parseInt(br.readLine());
        br.close();
    }

}