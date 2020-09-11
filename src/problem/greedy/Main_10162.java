package problem.greedy;
import java.io.*;

public class Main_10162 {
    static int[] times = {300, 60, 10};
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = input();
        solve(t);

        bw.flush();
        bw.close();
    }

    public static int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        return Integer.parseInt(input);
    }

    public static void solve(int t) throws IOException {
        int answer[] = new int[3];
        for (int i = 0; i < times.length; i++) {
            answer[i] = t / times[i];
            t = t % times[i];
        }
        if (t != 0) {
            bw.write("-1");
            return;
        }
        for (int i = 0; i < answer.length; i++) {
            bw.write(answer[i] + " ");
        }
    }
}
