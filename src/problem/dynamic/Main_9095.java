package problem.dynamic;

import java.io.*;

public class Main_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int answer[] = new int[num];
        d[0] = 1;
        d[1] = 1;
        d[2] = 2;
        for(int i=0; i<num; i++) {
            answer[i] = Integer.parseInt(br.readLine());
            answer[i] = solve(answer[i]);
        }
        print(answer);

        bw.flush();
        bw.close();
        br.close();
    }

    static int [] d = new int[1000001];

    public static int solve(int n){
        if(n<=1)
            d[n] = 1;
        if(d[n]>0)
            return d[n];
        d[n] = solve(n-1) + solve(n-2) + solve(n-3);
        return d[n];
    }

    public static void print(int[] answer){
        for(int i=0; i<answer.length-1; i++) {
            System.out.println(answer[i]);
        }
        System.out.print(answer[answer.length-1]);
    }
}
