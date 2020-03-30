package problem.greedy;
import java.io.*;

public class Main_1120 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] AB = input();
        int answer = solve(AB[0],AB[1]);

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
    public static String[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        return input;
    }
    public static int solve (String A, String B){
        int count = 0;
        int min = Integer.MAX_VALUE;
        if(A.length() == B.length()){
            for(int i=0; i<A.length(); i++){
                if(A.charAt(i) != B.charAt(i))
                    count++;
            }
            min = count;
        }
        else{
            for(int i=0; i < B.length()-A.length()+1; i++){
                String temp = B.substring(i,i+A.length());
                for(int j=0; j<A.length(); j++){
                    if(A.charAt(j) != temp.charAt(j) )
                        count++;
                }
                min = Math.min(min,count);
                count=0;
            }
        }
        return min;
    }
}
