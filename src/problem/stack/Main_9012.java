package problem.stack;

import java.util.Scanner;
import java.util.Stack;

public class Main_9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String[] parenthesis = new String[num];
        for (int i = 0; i < num; i++) {
            parenthesis[i] = sc.nextLine();
            System.out.println(valid(parenthesis[i]));
        }
    }
    public static String valid(String parenthesis){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < parenthesis.length(); i++) {
            char currentChar = parenthesis.charAt(i);
            if (currentChar == '(') {
                stack.push(currentChar);
            }
            else if ( currentChar == ')') {
                if(stack.isEmpty()){
                    return "NO";
                }
                else{
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
