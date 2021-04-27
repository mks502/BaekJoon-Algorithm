package problem.prefix_sum;

import java.io.*;

public class Main_11441 {
    static int sum[];
    static int num[];
    static BufferedReader br;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N = -1;
    static int M = -1;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N+1];
        sum = new int[N+1];
        String in[] = br.readLine().split(" ");
        for(int i=1; i<=N; i++){
            num[i] = Integer.parseInt(in[i-1]);
        }
        init();
        M = Integer.parseInt(br.readLine());
        for(int a=0; a<M; a++){
            String input[] = br.readLine().split(" ");
            int i = Integer.parseInt(input[0]);
            int j = Integer.parseInt(input[1]);
            solve(i,j);
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    public static void init(){
        for(int i=1; i<=N; i++){
            sum[i] = sum[i-1]+num[i];
        }
    }

    public static void solve(int start, int end){
        int result = sum[end] - sum[start-1];
        sb.append(result+"\n");
    }
}
