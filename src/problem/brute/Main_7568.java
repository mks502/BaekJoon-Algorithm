package problem.brute;

import java.io.*;

public class Main_7568 {
    public static void main(String[] args) throws IOException {

        int [][] people = input();
        int [] answer = solve(people);
        print(answer);

    }

    public static int[][] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] people = new int[n][2];
        for (int i=0; i<n; i++){
            String [] info = br.readLine().split(" ");
            people[i][0] = Integer.parseInt(info[0]);
            people[i][1] = Integer.parseInt(info[1]);
        }
        return people;
    }
    public static int[] solve (int [][] people){
        int [] rank = new int[people.length];
        for(int i=0; i<people.length; i++){
            rank[i]++;
            for(int j=0; j<people.length; j++){
                if(i==j)
                    continue;
                if( people[i][0] < people[j][0] && people[i][1] < people[j][1]  ){
                    rank[i]++;
                }
            }
        }
        return rank;
    }
    public static void print(int [] answer) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<answer.length-1; i++)
            bw.write(Integer.toString(answer[i])+" ");
        bw.write(Integer.toString( answer[answer.length-1] ));
        bw.flush();
        bw.close();
    }
}
