package problem.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_3190 {
    static int n ,l,k;
    static int board[][];
    static boolean visited[][];
    static Map<Integer,String> rotateTime = new HashMap<>();
    static Map<Integer,Integer[]> directionInfo = new HashMap<>();
    static Deque<Integer[]> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        input();
        directionInfo.put(1,new Integer[]{0,1}); // 동           →
        directionInfo.put(2,new Integer[]{1,0}); // 남           ↓
        directionInfo.put(3,new Integer[]{0,-1}); // 서          ←
        directionInfo.put(4,new Integer[]{-1,0}); // 북          ↑
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        l = Integer.parseInt(br.readLine());
        board = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];
        for(int i=0; i<l; i++){
            String temp[] = br.readLine().split(" ");
            int r = Integer.parseInt(temp[0]);
            int c = Integer.parseInt(temp[1]);
            board[r][c] = 1;
        }
        k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++){
            String temp[] = br.readLine().split(" ");
            rotateTime.put(Integer.parseInt(temp[0]),temp[1]);
        }
        br.close();
    }
    private static void solve(){
        int currentDirection = 1; // 오른쪽 시작
        int r = 1,c =1;
        int time = 0;
        deque.add(new Integer[]{1,1});
        board[1][1] = 2;
        while (true){
            time++;
            Integer[] move = directionInfo.get(currentDirection);
            Integer[] currentHead = deque.getFirst();
            r=currentHead[0]+move[0];
            c=currentHead[1]+move[1];

            if (r < 1 || c < 1 || r > n || c > n || board[r][c]==2)
                break;

            if(board[r][c] == 1) {              // 머리 위치에 사과가 있을 때  꼬리 유지
                board[r][c] = 2;
                deque.offerFirst(new Integer[]{r,c});
            }
            else{                               // 머리 위치에 사과가 없을 때 꼬리 제거
                board[r][c] = 2;
                deque.offerFirst(new Integer[]{r,c});
                Integer[] tailPosition = deque.removeLast();
                board[tailPosition[0]][tailPosition[1]]=0;
            }

            if(rotateTime.containsKey(time)){
                String rotation = rotateTime.get(time);
                if(rotation.equals("D")){
                    currentDirection++;
                }
                else{
                    currentDirection--;
                }

                if(currentDirection > 4){
                    currentDirection = 1;
                }
                if(currentDirection < 1){
                    currentDirection = 4;
                }
            }
        }
        System.out.println(time);
    }
}