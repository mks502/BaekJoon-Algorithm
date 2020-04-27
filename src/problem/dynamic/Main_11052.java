package problem.dynamic;
import java.io.*;

public class Main_11052 {
    public static int n;
    public static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cards[] = input();
        int answer = solve(cards);
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
    public static int solve(int[] cards){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++) {
                d[i] = Math.max(d[i] , d[i-j] + cards[j-1]);
            }
        }
        return d[n];
    }

    public static int[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int cards[] = new int [n];
        d = new int [n+1];
        String temp[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(temp[i]);
        }
        br.close();
        return cards;
    }
}
