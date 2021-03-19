package problem.binary_search.Q1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_1920_1 {
    static int n, m;
    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(temp[i]));
        }
        m = Integer.parseInt(br.readLine());
        temp = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(temp[i]);
            if (set.contains(num)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        br.close();
        System.out.println(sb.toString());
    }
}
