import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek15683 { // 감시
    static List<int[]> cctv;
    static List<Integer> gamsi = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1}; //상 하 좌 우
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        cctv = new ArrayList<>();
        int count = 0;

        // 사무실의 CCTV 정보 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0 && map[i][j] < 6)
                    cctv.add(new int[]{i, j});
                if (map[i][j] != 0) {
                    count++;
                }
            }
        }
        dfs(map, count, 0);
        System.out.println(n*m - Collections.max(gamsi));
    }

    private static void dfs(int[][] map, int count, int depth) {
        if (depth == cctv.size()) {
            gamsi.add(count);
            return;
        }
        int[][] origin = new int[map.length][map[0].length];
        // 값만 복사
        for (int o = 0; o < map.length; o++) {
            origin[o] = map[o].clone();
        }
        int x = cctv.get(depth)[0];
        int y = cctv.get(depth)[1];
        int tempCount = count;
        if (map[x][y] == 1) {
            tempCount += move(map,0, x, y);
            dfs(map, tempCount, depth + 1);
            for (int o = 0; o < map.length; o++) {
                map[o] = origin[o].clone();
            }

            tempCount = count;
            tempCount += move(map,1, x, y);
            dfs(map, tempCount, depth + 1);
            for (int o = 0; o < map.length; o++) {
                map[o] = origin[o].clone();
            }
            tempCount = count;
            tempCount += move(map,2, x, y);
            dfs(map, tempCount, depth + 1);
            for (int o = 0; o < map.length; o++) {
                map[o] = origin[o].clone();
            }
            tempCount = count;
            tempCount += move(map,3, x, y);
            dfs(map, tempCount, depth + 1);
            for (int o = 0; o < map.length; o++) {
                map[o] = origin[o].clone();
            }
        }
        if (map[x][y] == 2) {
            tempCount += move(map,0, x, y);
            tempCount += move(map,1, x, y);

            dfs(map, tempCount, depth + 1);
            for (int o = 0; o < map.length; o++) {
                map[o] = origin[o].clone();
            }

            tempCount = count;
            tempCount += move(map, 2,x, y);
            tempCount += move(map,3, x, y);

            dfs(map, tempCount, depth + 1);
            for (int o = 0; o < map.length; o++) {
                map[o] = origin[o].clone();
            }
        }
        if (map[x][y] == 3) {
            tempCount += move(map,0, x, y);
            tempCount += move(map, 3,x, y);

            dfs(map, tempCount, depth + 1);
            for (int o = 0; o < map.length; o++) {
                map[o] = origin[o].clone();
            }
            tempCount = count;
            tempCount += move(map,3, x, y);
            tempCount += move(map,1, x, y);
            dfs(map, tempCount, depth + 1);
            for (int o = 0; o < map.length; o++) {
                map[o] = origin[o].clone();
            }
            tempCount = count;
            tempCount += move(map,1, x, y);
            tempCount += move(map,2, x, y);
            dfs(map, tempCount, depth + 1);
            for (int o = 0; o < map.length; o++) {
                map[o] = origin[o].clone();
            }
            tempCount = count;
            tempCount += move(map,0, x, y);
            tempCount += move(map,2, x, y);
            dfs(map, tempCount, depth + 1);
            for (int o = 0; o < map.length; o++) {
                map[o] = origin[o].clone();
            }
        }
        if (map[x][y] == 4) {
            tempCount += move(map,0, x, y);
            tempCount += move(map,2, x, y);
            tempCount += move(map,3, x, y);
            dfs(map, tempCount, depth + 1);
            for (int o = 0; o < map.length; o++) {
                map[o] = origin[o].clone();
            }
            tempCount = count;
            tempCount += move(map, 0,x, y);
            tempCount += move(map,1, x, y);
            tempCount += move(map,3, x, y);
            dfs(map, tempCount, depth + 1);
            for (int o = 0; o < map.length; o++) {
                map[o] = origin[o].clone();
            }
            tempCount = count;
            tempCount += move(map,0, x, y);
            tempCount += move(map,1, x, y);
            tempCount += move(map, 2,x, y);
            dfs(map, tempCount, depth + 1);
            for (int o = 0; o < map.length; o++) {
                map[o] = origin[o].clone();
            }
            tempCount = count;
            tempCount += move(map,1, x, y);
            tempCount += move(map,2, x, y);
            tempCount += move(map,3, x, y);
            dfs(map, tempCount, depth + 1);
            for (int o = 0; o < map.length; o++) {
                map[o] = origin[o].clone();
            }
        }
        if (map[x][y] == 5) {
            tempCount += move(map,0, x, y);
            tempCount += move(map,1, x, y);
            tempCount += move(map,2, x, y);
            tempCount += move(map,3, x, y);

            dfs(map, tempCount, depth + 1);
            for (int o = 0; o < map.length; o++) {
                map[o] = origin[o].clone();
            }
        }
    }

    private static int move(int[][] map,int direction, int x, int y) {
        int tempX = dx[direction];
        int tempY = dy[direction];
        int tempCount = 0;
        while (x + tempX >= 0 && x + tempX < map.length && y + tempY >= 0 && y + tempY < map[0].length) {
            if (map[x + tempX][y + tempY] == 6) break;
            else if (map[x + tempX][y + tempY] == 0) {
                map[x + tempX][y + tempY] = -1;
                tempCount++;
            }
            if (tempX < 0) tempX--;
            else if (tempX > 0) tempX++;
            else if (tempY < 0) tempY--;
            else if (tempY > 0) tempY++;
        }
        return tempCount;
    }
}