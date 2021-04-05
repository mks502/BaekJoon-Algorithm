package problem.string.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main_5052 {

    static int t,n;
    static Trie trie;
    static StringBuilder sb = new StringBuilder();
    static String[] phoneNumbers;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(sb.toString());
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            trie = new Trie();
            n = Integer.parseInt(br.readLine());
            phoneNumbers = new String[n];
            for(int j=0; j<n; j++){
                phoneNumbers[j] = br.readLine();
            }
            solve();
        }
        br.close();
    }

    public static void solve() {
        Arrays.sort(phoneNumbers);
        for(int i=0; i<n; i++){
            if (trie.insert(phoneNumbers[i]) == false) {
                sb.append("NO\n");
                return;
            }
        }
        sb.append("YES\n");
    }

    static class TrieNode {

        public Map<Character, TrieNode> childNodes = new HashMap<>();
        private boolean isLastChar;

        public Map<Character, TrieNode> getChildNodes() {
            return this.childNodes;
        }

        public boolean isLastChar() {
            return this.isLastChar;
        }

        public void setLastChar(boolean lastChar) {
            this.isLastChar = lastChar;
        }
    }

    static class Trie {
        private TrieNode rootNode;

        public Trie() {
            rootNode = new TrieNode();
        }

        // 자식 노드 추가
        boolean insert(String word) {
            TrieNode thisNode = this.rootNode;

            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if(thisNode.childNodes.get(currentChar) == null){
                    thisNode.childNodes.put(currentChar,new TrieNode());
                }
                thisNode = thisNode.childNodes.get(currentChar);
                if(thisNode.isLastChar == true)
                    return false;
            }
            thisNode.setLastChar(true);
            return true;
        }
    }
}