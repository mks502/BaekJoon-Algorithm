package problem.dynamic;

import java.io.*;

public class Main_13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String [] input = br.readLine().split(" ");
        int [] nums = new int[n+1];
        int [] d = new int[n+1];
        int [] d2 = new int[n+1];
        for(int i=0; i<n; i++)
            nums[i] = Integer.parseInt(input[i]);

        d[0] = nums[0];
        for(int i=1; i<n; i++){
            d[i] = nums[i];
            if(d[i] < d[i-1] + nums[i] ){
                d[i] = d[i-1] + nums[i];
            }
        }
        for(int i=n-1; i>=0; i--){
            d2[i] = nums[i];
            if(i==n-1)
                continue;
            if(d2[i] < d2[i+1] + nums[i])
                d2[i] = d2[i+1] +nums[i];
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(i==0)
                max = d[i];
            else {
                max = Math.max(max, Math.max(d[i], d[i - 1] + d2[i + 1]));
            }
        }
        bw.write(Integer.toString(max));

        br.close();
        bw.flush();
        bw.close();
    }
}
