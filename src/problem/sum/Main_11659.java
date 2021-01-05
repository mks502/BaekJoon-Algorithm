package problem.sum;

import java.io.*;

public class Main_11659 {
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
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        num = new int[N+1];
        sum = new int[N+1];
        String input2[] = br.readLine().split(" ");
        for(int i=1; i<=N; i++){
            num[i] = Integer.parseInt(input2[i-1]);
        }
        init();
        for(int a=0; a<M; a++){
            String input3[] = br.readLine().split(" ");
            int i = Integer.parseInt(input3[0]);
            int j = Integer.parseInt(input3[1]);
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
