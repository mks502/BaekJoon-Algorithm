package problem.dynamic;

import java.io.*;

public class Main_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        bw.write(Integer.toString(caculate(num)));

        bw.flush();
        bw.close();
        br.close();
    }

    static int [] d = new int[1000001];

    public static int caculate(int n){
        d[0] = 1;
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        if(n<=1)
            d[n] = 1;
        if(d[n]>0)
            return d[n];
        d[n] = caculate(n-1) + caculate(n-2) + caculate(n-3);
        return d[n];
    }
}
