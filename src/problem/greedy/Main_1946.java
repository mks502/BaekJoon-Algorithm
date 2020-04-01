package problem.greedy;
import java.io.*;
import java.util.Arrays;

public class Main_1946 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            Rank[] ranks = new Rank[n];
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                Rank rank = new Rank(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
                ranks[j] = rank;
            }
            if( i!=t-1)
                bw.write(Integer.toString(solve(ranks,n))+"\n");
            else
                bw.write(Integer.toString(solve(ranks,n)));
        }
        bw.flush();
        bw.close();
    }
    public static class Rank implements Comparable<Rank> {
        public int first;
        public int second;

        public Rank(int first, int second){
            this.first=first;
            this.second=second;
        }

        @Override
        public int compareTo(Rank o) {
            if( this.first < o.first )
                return -1;
            else if(this.first == o.first){
                return 0;
            }
            else
                return 1;
        }
    }

    public static int solve (Rank[] ranks,int n) {
        int count = 1;
        Arrays.sort(ranks);
        int tempRank = ranks[0].second;
        for(int i=1; i<ranks.length; i++){
            if(tempRank > ranks[i].second){
                tempRank = ranks[i].second;
                count++;
            }
        }
        return count;
    }
}
