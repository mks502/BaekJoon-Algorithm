package problem.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1182 {
    static int n, s;
    static int[] nums;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(count);
    }



    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);
        nums = new int[n];

        String[] temp = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(temp[i]);
        }
    }

    public static void solve() {
        boolean[] visited = new boolean[n];
        for(int i=1; i<=n ; i++){
            combination(nums, visited, 0, n,i);
        }
    }

    static void combination(int[] arr, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            //다 뽑은 부분수열에 대해 합을 계산
            caculate(arr, visited, n);
            return;
        }

        if (depth == n) {
            return;
        }

        visited[depth] = true;
        combination(arr, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        combination(arr, visited, depth + 1, n, r);
    }

    static void caculate(int[] arr, boolean[] visited, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sum+=arr[i];
            }
        }
        if(sum==s){
            count++;
        }
    }
}
