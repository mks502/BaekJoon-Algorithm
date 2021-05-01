package problem.string.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_5670 {

    static int n;
    static Trie trie;
    static String[] word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ( (input = br.readLine()) != null ){
            n = Integer.parseInt(input);
            word = new String[n];
            for(int i=0; i<n; i++){
                word[i] = br.readLine();
            }
            inputTrie();
            solve();
        }
    }

    private static void inputTrie() {
        Arrays.sort(word);
        trie = new Trie();
        for(int i=0; i<n; i++){
            trie.insert(word[i]);
        }
    }

    private static void solve(){
        int count = 0;
        Arrays.sort(word);
        for(int i=0; i<n; i++) {
            int result = trie.contains(word[i]);
            count+=result;
        }
        System.out.println(String.format("%.2f",(double)count/n));
    }

    static class TrieNode {

        public Map<Character, TrieNode> childNodes = new HashMap<>();
        private boolean isLastString;

        public Map<Character, TrieNode> getChildNodes() {
            return this.childNodes;
        }

        public boolean isLastString() {
            return this.isLastString;
        }

        public void setLastString(boolean lastString) {
            this.isLastString = lastString;
        }
    }

    static class Trie {
        private TrieNode rootNode;

        public Trie() {
            rootNode = new TrieNode();
        }

        // 자식 노드 추가
        boolean insert(String str) {
            TrieNode thisNode = this.rootNode;

            for (int i = 0; i < str.length(); i++) {
                char currentString = str.charAt(i);
                if(thisNode.childNodes.get(currentString) == null){
                    thisNode.childNodes.put(currentString,new TrieNode());
                }
                thisNode = thisNode.childNodes.get(currentString);
            }
            thisNode.setLastString(true);
            return true;
        }

        int contains(String str) {
            TrieNode thisNode = this. rootNode;
            int count = 1;
            thisNode = thisNode.childNodes.get(str.charAt(0));
            for (int i = 1; i < str.length(); i++) {
                char currentChar = str.charAt(i);

                //자식노드 크기가 2이상이면 선택지가 2가지 이상이므로 입력해야한다
                if(thisNode.childNodes.size() >= 2){
                    count++;
                }

                //자식 노드가 하나라면 자동완성이 되지만 만약 이미 문자열이 완성 된 상태라면 다른 문자열을 위해 입력해야한다.
                if(thisNode.childNodes.size() == 1 && thisNode.isLastString){
                    count++;
                }

                thisNode = thisNode.childNodes.get(currentChar);
            }
            return count;
        }
    }
}