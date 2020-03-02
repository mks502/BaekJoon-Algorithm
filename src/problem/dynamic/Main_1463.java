package problem.dynamic;

import java.io.*;

public class Main_1463 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Integer num = Integer.parseInt(br.readLine());
        Integer result = makeOne(num);
        bw.write(result.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    public static int [] d = new int[1000001];

    public static int makeOne(int n){
        if(n==1){
            return 0;
        }
        if(d[n]>0) {
            return d[n];
        }
        int temp;
        d[n] = makeOne(n-1) +1;
        if(n%2==0){
            temp = makeOne(n/2) +1;
            if(d[n] > temp){
                d[n] = temp;
            }
        }
        if(n%3==0){
            temp = makeOne(n/3) +1;
            if( d[n] > temp){
                d[n] = temp;
            }
        }
        return d[n];
    }
}
