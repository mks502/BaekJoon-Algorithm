package problem.stack;

import java.io.*;
import java.util.Stack;

public class Main_9935 {
    static String s;
    static String bombString;
    static Stack<Character> stack;
    static Stack<Character> tempStack;
    static StringBuilder sb;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input();
        solve();
        bw.flush();
        bw.close();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        bombString = br.readLine();
        br.close();
    }

    static void solve() throws IOException {
        int lastIndex = bombString.length()-1;
        stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char currentChar = s.charAt(i);
            stack.push(currentChar);
            if(currentChar == bombString.charAt(lastIndex) && stack.size() >= bombString.length()) {
                tempStack = new Stack<>();
                for (int j = 0; j < bombString.length(); j++) {
                    char temp = stack.pop();
                    if (temp != bombString.charAt(bombString.length() - 1 - j)) {
                        stack.push(temp);
                        while (!tempStack.isEmpty()){
                            stack.push(tempStack.pop());
                        }
                        break;
                    }
                    tempStack.push(temp);
                }
            }
        }
        sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        if(sb.length()==0){
            bw.write("FRULA");
        }
        bw.write(sb.reverse().toString());
    }

}
