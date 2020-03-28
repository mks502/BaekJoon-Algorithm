package problem.dynamic;
import java.io.*;

public class Main_1932 {
    public static int[][] d = new int[501][501];
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int [][] triangle = input();
        int answer = solve(triangle,triangle.length);
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
    public static int[][] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int triangle [][] = new int[n][n];
        for(int i=0; i<n; i++){
            String [] input = br.readLine().split(" ");
            for(int j=0; j<=i; j++){
                triangle[i][j] = Integer.parseInt(input[j]);
            }
        }
        return triangle;
    }
    public static int solve(int [][] triangle,int n){
        int max = Integer.MIN_VALUE;
        d[0][0] = triangle[0][0];
        d[1][0] = triangle[1][0];
        for(int i=1; i<triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                if(j==0) {
                    d[i][j] = d[i - 1][j] + triangle[i][j];
                }
                else {
                    d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - 1]) + triangle[i][j];
                }
                max = Math.max(max,d[i][j]);
            }
        }
        return max;
    }
}
