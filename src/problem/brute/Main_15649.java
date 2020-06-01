package problem.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main_15649 {
    static int n,m;
    static boolean[] c = new boolean[10];
    static int[] a = new int[10];
    public static void main(String[] args) throws IOException {
        input();
        go(0,n,m);
    }

    static void go(int index, int n, int m) {
        if (index == m) {
            for (int i=0; i<m; i++) {
                System.out.print(a[i]);
                if (i != m-1) System.out.print(' ');
            }
            System.out.println();
            return;
        }
        for (int i=1; i<=n; i++) {
            if (c[i]) continue;
            c[i] = true;
            a[index] = i;
            go(index+1, n, m);
            c[i] = false;
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
    }
}
