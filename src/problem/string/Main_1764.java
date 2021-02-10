package problem.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1764 {

    static int N, M;
    static List<String> answerList;

    public static void main(String[] args) throws IOException {
        answerList = new ArrayList<>();
        solve();
    }

    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        Set<String> set = new HashSet();
        for (int i = 0; i < N + M; i++) {
            String currentName = br.readLine();
            if (!set.contains(currentName)) {
                set.add(currentName);
            } else {
                answerList.add(currentName);
            }
        }
        Collections.sort(answerList);
        System.out.println(answerList.size());
        for (int i = 0; i < answerList.size(); i++) {
            System.out.println(answerList.get(i));
        }
        br.close();
    }
}