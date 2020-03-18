package problem.greedy;

import java.io.*;
import java.util.Arrays;

public class Main_1931 {
    public static class Meeting implements Comparable<Meeting> {
        public int start;
        public int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Meeting o) {
            if (this.end < o.end) {
                return -1;
            } else if (this.end == o.end) {
                if (this.start < o.start) {
                    return -1;
                } else if (this.start == o.start) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        int answer = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Meeting [] meetings = new Meeting[n];
        for(int i=0; i<n; i++){
            String [] input1 = br.readLine().split(" ");
            meetings[i] = new Meeting(Integer.parseInt(input1[0]),Integer.parseInt(input1[1]));
        }
        Arrays.sort(meetings);
        int temp = meetings[0].end;
        for(int i=1; i<n; i++){
            if(meetings[i].start >= temp){
                temp = meetings[i].end;
                answer++;
            }
        }
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
