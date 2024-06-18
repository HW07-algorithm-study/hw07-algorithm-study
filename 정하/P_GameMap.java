package 정하;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dx = {1, -1, 0, 0}; // 좌,우,상,하
    static int[] dy = {0, 0, 1, -1}; // 좌,우,상,하

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        // 맵의 크기 좌표 사용 여부
        boolean[][] visited = new boolean[n][m];
        return bfs(maps, visited, 0, 0, n, m);
    }

    public static int bfs(int[][] maps, boolean[][] visited, int startX, int startY, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
//        큐에 시작 좌표 추가하고 사용으로 체크
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
//            현재 좌표에서
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
//            상하좌우 체크
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
//                    현재 좌표 방문하지 않았고 벽이 아니라면
                    if (!visited[nx][ny] && maps[nx][ny] == 1) {
//                        현재 좌표 추가, 방문 처리, 맵 자체에 거리 저장
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[x][y] + 1;
                    }
                }
            }
        }
//        삼항 연산자 사용하여 5,5좌표의 값 1이면 갈 수 있는 방법이 없으므로 -1
//        아니면 지금까지 거리 반환
        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
    }
}