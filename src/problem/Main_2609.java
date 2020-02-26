package problem;

import java.io.*;

public class Main_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] temp = br.readLine().split(" ");
        int num[] = new int[temp.length];
        for(int i=0; i<temp.length; i++){
            num[i] = Integer.parseInt(temp[i]);
        }
        int gcd = gcdCaculate(num[0],num[1]);
        // lcm = ( A * B ) / gcd
        int lcm = (num[0] * num[1]) / gcd;
        bw.write(String.valueOf(gcd)+"\n");
        bw.write(String.valueOf(lcm));
        bw.flush();
        br.close();
        bw.close();
    }
    public static int gcdCaculate(int a,int b){
        if(b == 0) {
            return a;
        }
        else {
            return gcdCaculate(b, a % b);
        }
    }
}
