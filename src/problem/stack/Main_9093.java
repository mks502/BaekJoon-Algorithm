package problem.stack;

import java.util.Scanner;
import java.util.Stack;

public class Main_9093{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number= Integer.parseInt(sc.nextLine());
        String[] lines = new String[number];
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<number; i++){
            StringBuilder sb = new StringBuilder();
            lines[i] = sc.nextLine();
            lines[i] += '\n';
            for(int j=0; j<lines[i].length(); j++){
                if(lines[i].charAt(j)==' ' || lines[i].charAt(j)=='\n'){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    if (lines[i].charAt(j) == ' ') {
                        sb.append(lines[i].charAt(j));
                    }
                }
                else{
                    stack.push(lines[i].charAt(j));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
