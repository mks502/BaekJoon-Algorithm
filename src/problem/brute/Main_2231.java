package problem.brute;

import java.io.*;

public class Main_2231 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = input();
        int answer = solve(n);
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

    public static int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        return n;
    }

    public static int solve (int n){
        for(int i=1; i<n; i++){
            if(i + apart(i) == n) {
                return i;
            }
        }
        return 0;
    }
    public static int apart (int n){
        String num = Integer.toString(n);
        String temp[] = num.split("");
        int result = 0;
        for(int i=0; i<temp.length; i++){
            result += Integer.parseInt(temp[i]);
        }
        return result;
    }
}
