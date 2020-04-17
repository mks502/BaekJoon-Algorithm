package problem.dynamic;
import java.io.*;

public class Main_2579 {
    public static long[] d = new long[301];
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int [] stair = input();
        long answer = solve(stair,stair.length-1);
        bw.write(Long.toString(answer));
        bw.flush();
        bw.close();
    }
    public static int[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int stair [] = new int[n+1];
        for(int i=1; i<=n; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }
        return stair;
    }
    public static long solve(int [] stair,int n){
        d[1] = stair[1];
        if(n>=2)
            d[2] = Math.max(stair[1] + stair[2],stair[2]);
        for(int i=3; i<=n; i++) {
            d[i] = Math.max(d[i - 3] + stair[i - 1] + stair[i], d[i - 2] + stair[i]);
        }
        return d[n];
    }
}
