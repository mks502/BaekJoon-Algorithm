package problem.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2947 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        int treePieces[] = new int[temp.length];

        for(int i=0; i<temp.length; i++) {
            treePieces[i] = Integer.parseInt(temp[i]);
        }
        solve(treePieces);

        br.close();
    }

    private static int[] solve(int treePieces[]){
        for(int i=0; i<treePieces.length-1; i++){
            if(treePieces[i] > treePieces[i+1]){
                int temp = treePieces[i];
                treePieces[i] = treePieces[i+1];
                treePieces[i+1] = temp;
                print(treePieces);
            }
        }
        for(int i=0; i<treePieces.length; i++){
            if(treePieces[i] != i+1){
                solve(treePieces);
            }
        }
        return treePieces;
    }

    private static void print(int treePieces[]){
        for(int i=0; i< treePieces.length; i++){
            System.out.print(treePieces[i]+" ");
        }
        System.out.println();
    }
}
