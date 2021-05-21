package problem.brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1327 {
    static int n, k;
    static int count = 0;
    static String sequence;
    static Set<String> visited = new HashSet<>();
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(bfs(sequence));
    }

    private static class Node {
        private String sequence;
        private int currentReverseCount;

        public Node(String sequence, int currentReverseCount) {
            this.sequence = sequence;
            this.currentReverseCount = currentReverseCount;
        }

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        sequence = br.readLine().replaceAll(" ","");
    }

    private static int bfs(String str) {
        String target = sort(str);
        queue.offer(new Node(str,0));
        visited.add(str);

        while (! queue.isEmpty()){
            Node currentNode = queue.poll();
            String currentStr  = currentNode.sequence;
            int currentReverseCount = currentNode.currentReverseCount;
            if(currentStr.equals(target)){
                return currentReverseCount;
            }

            for(int i=0; i<=n-k; i++){
                String reverseStr = reverse(currentStr,i,i+k);
                if(!visited.contains(reverseStr)){
                    visited.add(reverseStr);
                    queue.offer(new Node(reverseStr,currentReverseCount+1));
                    count++;
                }
            }
        }
        return -1;
    }

    private static String reverse(String str, int startIndex, int endIndex){
        StringBuilder sb = new StringBuilder();
        String targetString = str.substring(startIndex,endIndex);
        for(int i= targetString.length()-1; i>=0; i--){
            sb.append(targetString.charAt(i));
        }
        return str.substring(0,startIndex) + sb + str.substring(endIndex);
    }

    private static String sort(String target){
        char temp[] = target.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

}
