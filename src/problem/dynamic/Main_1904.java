package problem.dynamic;
import java.io.*;

public class Main_1904 {
    public static int[] d = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = input();
        int answer = solve(n);
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
    public static int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }
    public static int solve(int n){
        d[0] = 1;
        d[1] = 1;
        for(int i=2; i<=n; i++){
            d[i] = d[i-1]%15746 +d[i-2]%15746;
        }
        return d[n]%15746;
    }
}