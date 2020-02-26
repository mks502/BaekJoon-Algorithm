package problem.stack;

import java.io.*;
import java.util.Stack;

public class Main_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        int input[] = new int[num];
        for(int i=0; i<temp.length; i++){
            input[i] = Integer.parseInt(temp[i]);
        }
        int[] res = rightBigNum(input);
        for (int i=0; i<res.length; i++) {
            bw.write(res[i]+" ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
    static int[] rightBigNum(int[] numbers){
        int [] result = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<numbers.length; i++){
            if(stack.isEmpty()) {
                stack.push(i);
            }
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                result[stack.peek()] = numbers[i];
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            result[stack.peek()] = -1;
            stack.pop();
        }
        return result;
    }
}
