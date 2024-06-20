import java.util.*;

class Solution {
    // 방향 벡터: 오른쪽, 아래, 왼쪽, 위쪽
    private static final int[] DX = {1, 0, -1, 0};
    private static final int[] DY = {0, 1, 0, -1};

    public int solution(int[][] maps) {
        // 방문 여부 및 최단 경로 길이를 기록할 배열
        int[][] distance = new int[maps.length][maps[0].length];
        // BFS를 통해 거리 계산
        bfs(maps, distance);
        // 목적지에 도달한 경우의 값을 반환
        int result = distance[maps.length - 1][maps[0].length - 1];
        // 목적지에 도달하지 못한 경우 -1 반환
        return (result == 0) ? -1 : result;
    }

    private void bfs(int[][] maps, int[][] distance) {
        int startX = 0;
        int startY = 0;
        distance[startX][startY] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int currX = current[0];
            int currY = current[1];

            // 네 방향으로 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = currX + DX[i];
                int nextY = currY + DY[i];

                // 맵의 경계를 벗어나는지 확인
                if (nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length) {
                    continue;
                }

                // 방문하지 않았고, 갈 수 있는 길인지 확인
                if (distance[nextX][nextY] == 0 && maps[nextX][nextY] == 1) {
                    distance[nextX][nextY] = distance[currX][currY] + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}
