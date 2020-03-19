package problem.greedy;
import java.io.*;
import java.util.Arrays;

public class Main_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int time[] = new int[n];
        int answer = 0;
        int minute = 0;
        String [] input = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            time[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(time);

        for(int i=0; i<n; i++){
            minute+=time[i];
            answer+=minute;
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
