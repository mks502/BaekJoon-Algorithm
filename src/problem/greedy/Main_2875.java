package problem.greedy;
import java.io.*;
public class Main_2875 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int [] NMK = input();
        int answer = solve(NMK[0],NMK[1],NMK[2]);

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
    public static int[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int [] NMK = new int[3];
        for(int i=0; i<3; i++)
            NMK[i] = Integer.parseInt(input[i]);
        return NMK;
    }
    public static int solve(int n, int m, int k){
        int teamCount = 0;
        while (n>=2 && m>=1 && k<=(m-2)+(n-1) ){
            n=n-2;
            m=m-1;
            teamCount++;
        }
        return teamCount;
    }
}
