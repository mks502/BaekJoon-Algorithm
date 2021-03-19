package problem.binary_search.Q1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1920_2 {
    static int n, m;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(temp[i]);
        }

        m = Integer.parseInt(br.readLine());
        temp = br.readLine().split(" ");

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(temp[i]);
            binarySearch(0,n-1,num);
        }

        br.close();
        System.out.println(sb.toString());
    }

    private static void binarySearch(int start,int end,int data){
        Arrays.sort(numbers);
        while (start <= end) {
            int mid = (start + end) / 2;
            if (numbers[mid] == data) {
                sb.append("1\n");
                return;
            }
            else if(numbers[mid] < data){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        sb.append("0\n");
    }
}
