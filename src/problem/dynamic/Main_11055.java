package problem.dynamic;

import java.io.*;

public class Main_11055 {
    public static void main(String[] args) throws IOException {
        int max = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int numbers[] = new int[num];
        int d [] = new int[num+1];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < temp.length; i++)
            numbers[i] = Integer.parseInt(temp[i]);

        for(int i=0; i<num; i++){
            if(i==0)
                max = numbers[i];
            d[i] = numbers[i];
            for(int j=0; j<i; j++){
                if( numbers[j] < numbers[i] && d[i] < d[j] +numbers[i])
                    d[i] = d[j] +numbers[i];
                if( max < d[i] )
                    max = d[i];
            }
        }

        bw.write(Integer.toString(max));

        bw.flush();
        bw.close();
        br.close();
    }

}
