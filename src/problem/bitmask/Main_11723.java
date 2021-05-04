package problem.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11723 {

    static int s = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            execute(br.readLine());
        }
        System.out.println(sb.toString());
        br.close();
    }

    public static void execute(String command) {
        String temp[] = command.split(" ");
        int num = 0;
        String operation = temp[0];
        if (temp.length == 2) {
            num = Integer.parseInt(temp[1]);
        }

        switch (operation) {
            case "add":
                s |= (1 << num);
                break;

            case "remove":
                s &= ~(1 << num);
                break;

            case "check":
                sb.append( ( (s & (1 << num)) >> num) + "\n" );
                break;

            case "toggle":
                s ^= (1 << num);
                break;

            case "all":
                s |= (~0);
                break;

            case "empty":
                s &= 0;
                break;
        }
    }
}
