package problem.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1062 {

    static int n,k;
    static String[] words;
    static Set<Character> set;
    static List<Character> list;
    static boolean[] visited;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        set = new HashSet<>();
        input();
        System.out.println(max);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        k = Integer.parseInt(temp[1]);
        words = new String[n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            words[i] = str.substring(4,str.length()-4);
            for(int j=0; j<words[i].length(); j++){
                char currentChar = words[i].charAt(j);
                if(currentChar == 'a' || currentChar == 't' || currentChar == 'n' || currentChar == 'i' || currentChar == 'c'){
                    continue;
                }
                set.add(currentChar);
            }
        }
        list = new ArrayList<>(set);
        visited = new boolean[set.size()];
        if(k < 5){
            max = 0;
        }
        else {
            combination(0, 0, set.size() , k - 5);
        }
        br.close();
    }

    public static void combination(int index, int depth, int n , int r){
        if(depth == r || depth==n){          // n개를 이미 다 골랐거나 r개를 골름
            max = Math.max(max,print());
            return;
        }
        for(int i=index; i<n; i++){
            if( !visited[i]){
                visited[i] = true;
                combination(i,depth+1,n,r);
                visited[i] = false;
            }
        }
    }

    public static int print() {
        int count = 0;
        Set tempSet = new HashSet();
        tempSet.add('a');
        tempSet.add('t');
        tempSet.add('n');
        tempSet.add('i');
        tempSet.add('c');
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                tempSet.add(list.get(i));
            }
        }

        for(int i=0; i<words.length; i++){
            boolean check = true;
            for(int j=0; j<words[i].length(); j++){
                char currentChar = words[i].charAt(j);
                if(currentChar == 'a' || currentChar == 't' || currentChar == 'n' || currentChar == 'i' || currentChar == 'c'){
                    continue;
                }
                if( !tempSet.contains(currentChar) ){
                    check = false;
                }
            }
            if(check)
                count++;
        }
        return count;
    }
}