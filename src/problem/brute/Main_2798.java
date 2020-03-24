package problem.brute;

import java.io.*;

public class Main_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] input = br.readLine().split(" ");
        int answer = Integer.MIN_VALUE;
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        String [] input2 = br.readLine().split(" ");
        int [] card = new int[n];
        for(int i=0; i<n; i++){
            card[i] = Integer.parseInt(input2[i]);
        }
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    int sum = card[i]+card[j]+card[k];
                    if(sum <= m && answer <= sum){
                        answer = sum;
                    }
                }
            }
        }
        bw.write(Integer.toString(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
