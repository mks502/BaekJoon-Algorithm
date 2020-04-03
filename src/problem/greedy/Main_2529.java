package problem.greedy;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main_2529 {
    public static List<String> numList = new ArrayList<>();
    public static boolean [] visited = new boolean[10];
    public static String [] symbol;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        symbol = input();
        for(int i=0; i<=9; i++){
            visited[i] = true;
            solve(i,0,i+"",symbol.length);
        }
        bw.write(numList.get(numList.size()-1)+"\n");
        bw.write(numList.get(0));
        bw.flush();
        bw.close();
    }
    public static String[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String [] input = br.readLine().split(" ");
        return input;
    }

    public static void solve (int num, int index, String k,int n) {
        if(index == n){
            numList.add(k);
        }
        else{
            for(int i=0; i<=9; i++){
                if(!visited[i]){
                    if(symbol[index].equals("<")){
                        if(num >= i){
                            continue;
                        }
                    }
                    else{
                        if(num <= i){
                            continue;
                        }
                    }
                    visited[i]=true;
                    solve(i,index+1,k+i,n);
                }
            }
        }
        visited[num] = false;
    }
}