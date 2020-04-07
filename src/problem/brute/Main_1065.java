package problem.brute;

import java.io.*;

public class Main_1065 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int count = 0;
        if(Integer.parseInt(n) < 100){
            count+=Integer.parseInt(n);
        }
        else{
            count = 99;
        }
        for (int i=100; i<=Integer.parseInt(n); i++) {
            if (solve(Integer.toString(i)))
                count++;
        }
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
        br.close();
    }
    public static boolean solve (String n){
        String temp[] = n.split("");
        int diff = 0;
        if(n.length() >= 2)
            diff = Integer.parseInt(temp[1]) - Integer.parseInt(temp[0]);
        for(int i=2; i<temp.length; i++){
            if( Integer.parseInt(temp[i]) - Integer.parseInt(temp[i-1]) != diff)
                return false;
        }
        return true;
    }
}
