package problem.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1181 {

    static int N;
    static List<String> wordList;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Set<String> wordSet = new HashSet();
        for (int i = 0; i < N; i++) {
            wordSet.add(br.readLine());
        }
        wordList = new ArrayList<>(wordSet);
        br.close();
    }

    public static void solve() {
        Collections.sort(wordList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() > s2.length()) {
                    return 1;
                } else if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                } else
                    return -1;
            }
        });

        for (int i = 0; i < wordList.size(); i++) {
            System.out.println(wordList.get(i));
        }
    }
}