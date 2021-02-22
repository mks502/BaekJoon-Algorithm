package problem.stack;

import java.io.*;
import java.util.Stack;

public class Main_10773 {
    static int k;
    static Stack<Integer> stack;
    static int sum = 0;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        stack = new Stack<>();
        solve();
        bw.flush();
        bw.close();
    }

    static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++ ){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                stack.pop();
            }
            else {
                stack.push(num);
            }
        }
        while (!stack.isEmpty()){
            sum+=stack.pop();
        }
        System.out.println(sum);
        br.close();
    }
}
