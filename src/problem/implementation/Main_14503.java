package problem.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_14503 {

    static Map<Integer, Integer[]> directionInfo;
    static int n, m;
    static int board[][];
    static int currentDirection;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        board = new int[n][m];

        temp = br.readLine().split(" ");
        int r = Integer.parseInt(temp[0]);
        int c = Integer.parseInt(temp[1]);
        currentDirection = Integer.parseInt(temp[2]);

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(temp[j]);
            }
        }
        init();
        solve(r, c, currentDirection);
        System.out.println(count);

        br.close();
    }

    private static void init() {
        // 동서남북 각 방향에 대한 이동 정보
        directionInfo = new HashMap<>();
        directionInfo.put(0, new Integer[]{-1, 0}); // 북          ↑
        directionInfo.put(1, new Integer[]{0, 1}); // 동           →
        directionInfo.put(2, new Integer[]{1, 0}); // 남           ↓
        directionInfo.put(3, new Integer[]{0, -1}); // 서          ←
    }

    private static void solve(int r, int c, int currentDirection) {
        board[r][c] = -1;
        count++;

        while (true) {
            boolean isPossible = false;
            for (int i = 0; i < 4; i++) {

                // 왼쪽으로 회전 (반 시계방향)
                if (--currentDirection < 0) {
                    currentDirection = 3;
                }

                int nextR = r + directionInfo.get(currentDirection)[0];
                int nextC = c + directionInfo.get(currentDirection)[1];

                if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= m || board[nextR][nextC] == -1 || board[nextR][nextC] == 1) {
                    continue;
                }

                //청소 가능한 곳 발견
                if (board[nextR][nextC] == 0) {
                    r = nextR;
                    c = nextC;
                    isPossible = true;
                    break;
                }
            }

            //청소 가능
            if (isPossible) {
                board[r][c] = -1;
                count++;
            } else {       //4방향 모두 청소 불가능 방향은 유지상태로 후진 시켜줘야함
                r -= directionInfo.get(currentDirection)[0];
                c -= directionInfo.get(currentDirection)[1];

                //뒤쪽 방향이 벽이라 후진 불가 멈춤
                if (board[r][c] == 1) {
                    return;
                }
            }
        }
    }
}
