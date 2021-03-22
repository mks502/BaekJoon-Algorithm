package problem.binary_search.Q2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2805_2 {
    static int n, m;
    static int trees[];
    static int max = Integer.MIN_VALUE;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        binarySearch();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        trees = new int[n];
        temp = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            trees[i] = Integer.parseInt(temp[i]);
            max = Math.max(max,trees[i]);
        }
        br.close();
    }

    private static long caculateHeight(int h){
        long sum=0l;
        for(int i=0; i<n; i++){
            if(trees[i] > h) {
                sum += (trees[i] - h);
            }
        }
        return sum;
    }


    private static void binarySearch(){
        int start = 0;
        int end = max;
        while (start<=end) {
            long sum;
            int mid = (start+end)/2;
            sum = caculateHeight(mid);
            if(sum < m) {
                end = mid-1;
            }
            else {
                start = mid+1;
                answer = Math.max(answer, mid);
            }
        }

    }
}
