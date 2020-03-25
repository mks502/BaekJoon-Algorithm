package problem;
import java.io.*;
public class Main_2869 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] ABV = input();

        int answer = solve(ABV[0],ABV[1],ABV[2]);

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

    public static int[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int [] ABV = new int[input.length];
        for(int i=0; i<input.length; i++){
            ABV[i] = Integer.parseInt(input[i]);
        }
        return ABV;
    }

    public static int solve (double A,double B, double V){
        if(V==A)
            return 1;
        int day = (int) Math.ceil((V-A)/(A-B)+1);
        return day;
    }
}