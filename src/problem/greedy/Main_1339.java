package problem.greedy;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Main_1339 {
    static int N;
    static String words[];

    static class ValueComparator implements Comparator<Character> {

        Map<Character, Integer> base;

        public ValueComparator(Map<Character, Integer> base) {
            this.base = base;
        }

        public int compare(Character a, Character b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        Map<Character,Integer> map = new HashMap<>();
        ValueComparator valueComparator = new ValueComparator(map);
        TreeMap<Character,Integer> sortedMap = new TreeMap<>(valueComparator);
        input();
        for(int i=0; i<N; i++){
            String word = words[i];
            for(int j=0; j<word.length(); j++){
                char c = word.charAt(j);
                int num = (int) Math.pow(10 ,word.length()-j-1);
                if(map.containsKey(c) ){
                    int temp = map.get(c);
                    map.put(c,num+temp);
                }
                else{
                    map.put(c,num);
                }
            }
        }
        sortedMap.putAll(map);
        int answer = 0;
        int num = 9;
        for (Map.Entry<Character,Integer> entry : sortedMap.entrySet()) {
            int value = map.get(entry.getKey());
            answer += (value*num--);
        }
        System.out.println(answer);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];
        for(int i=0; i<N; i++){
            words[i] = br.readLine();
        }
        br.close();
    }

}