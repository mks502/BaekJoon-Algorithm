package problem.implementation;

import java.io.*;

public class Main_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int e,s,m;
        int year = 0;

        String[] split = br.readLine().split(" ");
        e = Integer.parseInt(split[0]);
        s = Integer.parseInt(split[1]);
        m = Integer.parseInt(split[2]);

        int earth = 0;
        int sun = 0;
        int moon = 0;
        while (earth != e || sun != s || moon != m){
            year++;
            if(++earth > 15){
                earth = 1;
            }
            if(++sun > 28){
                sun = 1;
            }
            if(++moon > 19){
                moon = 1;
            }
        }

        bw.write(String.valueOf(year));

        br.close();
        bw.flush();
        bw.close();
    }
}
