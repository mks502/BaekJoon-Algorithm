package problem;

import java.io.*;

public class Main_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] word = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String content = br.readLine();
        for(int i=0; i<word.length; i++) {
            if(content.contains(word[i])) {
                content = content.replaceAll(word[i], "@");
            }
        }
        bw.write(Integer.toString(content.length()));
        bw.flush();
        bw.close();
        br.close();
    }
}
