package problem.greedy;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main_10610 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String n = input();
        String answer = solve(n);

        bw.write(answer);
        bw.flush();
        bw.close();
    }
    public static String input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        return input;
    }
    public static String solve (String n){
        if(! n.contains("0"))
            return "-1";
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        String nums[] = n.split("");
        Arrays.sort(nums, Comparator.reverseOrder());
        for(int i=0; i< nums.length; i++){
            sum += Integer.parseInt(nums[i]);
            sb.append(nums[i]);
        }
        if(sum % 3 == 0){
            return sb.toString();
        }
        return "-1";
    }

}
