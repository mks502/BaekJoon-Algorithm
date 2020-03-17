package problem.dynamic;

import java.io.*;

public class Main_11054 {
    public static void main(String[] args) throws IOException {
        int max = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int numbers[] = new int[num];
        int d [] = new int[num+1];
        int d1 [] = new int [num+1];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < temp.length; i++)
            numbers[i] = Integer.parseInt(temp[i]);

        for(int i=0; i<numbers.length; i++){
            d[i] = 1;
            for(int j=0; j<i; j++){
                if(numbers[j] < numbers[i] && d[i] < d[j]+1 ){
                    d[i] = d[j] + 1;
                }
            }
        }

        //i번째부터 감소하는 수열
        for(int i=num-1; i>=0; i--){
            d1[i] = 1;
            for(int j=i+1; j<num; j++){
                if(numbers[j] < numbers[i] && d1[i] < d1[j]+1 ){
                    d1[i] = d1[j] + 1;
                }
            }
        }

        for(int i=0; i<num; i++){
            if(i==0)
                max = d[i]+d1[i]-1;
            if(max < d[i] + d1[i] -1)
                max = d[i] + d1[i] -1;
        }

        bw.write(Integer.toString(max));

        bw.flush();
        bw.close();
        br.close();
    }

}
