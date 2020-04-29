package problem.dynamic;

import java.io.*;

public class Main_2163 {
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input();
        bw.write(Integer.toString(solve()));
        bw.flush();
        bw.close();
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        br.close();
    }
    public static int solve(){
        return (n-1) + n*(m-1);
    }

}
