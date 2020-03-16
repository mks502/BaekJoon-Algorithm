package problem.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max=0;

        int n = Integer.parseInt(br.readLine());
        int [] nums = new int[n+1];
        int [] d = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1; i<=n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        d[1] = nums[1];
        max = d[1];
        for(int i=2; i<=n; i++){
            d[i] = nums[i];
            if(d[i] < d[i-1] + nums[i] )
                d[i] = d[i-1] + nums[i];
            if(max < d[i])
                max = d[i];
        }
        bw.write(Integer.toString(max));

        bw.flush();
        bw.close();
        br.close();
    }
}
