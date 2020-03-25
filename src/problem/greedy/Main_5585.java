package problem.greedy;

import java.io.*;

public class Main_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] coin = {500,100,50,10,5,1};
        int money = 1000 - Integer.parseInt(br.readLine());
        int i = 0;
        int answer = 0;
        while( money > 0 && i<coin.length ){
            int num = money /coin[i];
            money = money % coin[i];
            answer += num;
            i++;
        }
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
