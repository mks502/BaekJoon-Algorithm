package problem.greedy;

import java.io.*;

public class Main_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int [] coin = new int [n];
        for(int i=0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        int i=n-1;
        int answer = 0;

        while( k> 0 && i>=0) {
            int num = k / coin[i];
            k %= coin[i];
            answer += num;
            i--;
        }
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
