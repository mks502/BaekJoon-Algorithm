package problem.dynamic;

import java.io.*;

public class Main_9461 {
    public static Long [] p = new Long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Long n = Long.parseLong(br.readLine());
        p[1] = Long.valueOf(1);
        p[2] = Long.valueOf(1);
        p[3] = Long.valueOf(1);
        for(int i=0; i<n; i++){
            Long answer = solve(Integer.parseInt(br.readLine()));
            if(i!=n-1)
                bw.write(Long.toString(answer)+"\n");
            else
                bw.write(Long.toString(answer));
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static Long solve(int n){
        for(int i=4; i<=n; i++){
            p[i] = p[i-3]+p[i-2];
        }
        return p[n];
    }
}
