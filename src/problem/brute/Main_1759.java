package problem.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1759 {
    static int L, C;
    static String[] alphabet;
    static char[] vowels = {'a','e','i','o','u'};
    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(alphabet);
        solve();
    }



    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        alphabet = br.readLine().split(" ");
    }

    public static void solve() {
        boolean[] visited = new boolean[C];
        combination(alphabet, visited, 0, C,L);

    }

    static void combination(String[] arr, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            checkWord(arr, visited, n);
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

    static void checkWord(String[] arr, boolean[] visited,int n){
        int vowelCount = 0;
        int consonantCount = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if(visited[i]){
                sb.append(arr[i]);
                char currentChar = arr[i].charAt(0);
                if( isVowel(currentChar) ){
                    vowelCount++;
                }else{
                    consonantCount++;
                }
            }
        }
        if(vowelCount >= 1 && consonantCount >= 2){
            System.out.println(sb.toString());
        }
    }

    static boolean isVowel(char c){
        for(int i=0; i<vowels.length; i++){
            if(vowels[i] == c){
                return true;
            }
        }
        return false;
    }
}
