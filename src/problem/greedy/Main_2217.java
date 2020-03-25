package problem.greedy;
import java.io.*;
import java.util.Arrays;

public class Main_2217 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] rope = input();

        int answer = solve(rope.length,rope);

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

    public static int[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] rope = new int[n];
        for(int i=0; i<n; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }
        return rope;
    }

    public static int solve (int k,int rope[]){
        Arrays.sort(rope);
        int max = Integer.MIN_VALUE;
        for(int i=k-1; i>=0; i--){
            max = Math.max(max,(k-i)*rope[i]);
        }
        return max;
    }

}
