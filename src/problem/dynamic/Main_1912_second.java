package problem.dynamic;
import java.io.*;

public class Main_1912_second {
    public static int n;
    public static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int nums[] = input();
        int answer = solve(nums);
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
    public static int solve(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            d[i] = Math.max(d[i-1] + nums[i], nums[i]);
            max = Math.max(max,d[i]);
        }
        return max;
    }
    public static int[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d = new int[n+1];
        String temps[] = br.readLine().split(" ");
        int nums[] = new int[n+1];
        for(int i=1; i<=n; i++)
            nums[i] = Integer.parseInt(temps[i-1]);
        return nums;
    }
}
