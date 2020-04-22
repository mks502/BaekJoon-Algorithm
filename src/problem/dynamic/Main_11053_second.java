package problem.dynamic;
import java.io.*;

public class Main_11053_second {
    public static int n;
    public static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numbers[] = input();
        int answer = solve(numbers);
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
    public static int solve(int[] numbers){
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            d[i] = 1;
            for(int j=1; j<i; j++) {
                if(numbers[j] < numbers[i] && d[i] < d[j] + 1){
                    d[i] = d[j] + 1;
                }
            }
            max = Math.max(max, d[i]);
        }
        return max;
    }

    public static int[] input () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d = new int[n+1];
        String temp[] = br.readLine().split(" ");
        int numbers[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(temp[i-1]);
            d[i] = 1;
        }
        br.close();
        return numbers;
    }
}
