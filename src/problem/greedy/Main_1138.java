package problem.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main_1138 {

    static int N;
    static int[] info;
    static int[] order;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        for(int i=0; i<order.length; i++){
            System.out.print(order[i]+" ");
        }
    }

    public static void solve(){
        for(int i=0; i<info.length;){
            int num = info[i];
            int c = 0;
            for(int j=0; j<order.length; j++){
                boolean check = false;
                if(c==num){
                    for(int k=j; k< info.length; k++) {
                        if(order[k]==0){
                            order[k] = (++i);
                            c=0;
                            check = true;
                            break;
                        }
                    }
                }
                if(order[j] == 0){
                    c++;
                }
                if(check)
                    break;
            }
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        info = new int[N];
        order = new int[N];
        String temp[] = br.readLine().split(" ");
        for(int i=0; i<temp.length; i++){
            info[i] = Integer.parseInt(temp[i]);
        }
        br.close();
    }

}