package problem.greedy;
import java.io.*;
import java.util.Arrays;

public class Main_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num=0;
        int answer = 0;
        int flag = 1;
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        for(int i=0; i<input.length(); i++){
            char currentChar = input.charAt(i);
            if(currentChar >= '0' && currentChar <= '9'){
                sb.append(currentChar);
            }
            else{
                num = Integer.parseInt(sb.toString());
                sb.delete(0,sb.length());
                if(flag==1){
                    answer+=num;
                }
                else{
                    answer-=num;
                }
                if(flag==1 && currentChar=='-'){
                    flag *= -1;
                }
            }
        }
        num = Integer.parseInt(sb.toString());
        answer = answer + (flag*num);

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
