import java.util.*;

public class 게임맵최단거리{
    // 게임 맵 최단거리
    public static int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length; // 행
        int m = maps[0].length; // 열
        int[][] visited = new int[n][m]; // 방문한 곳을 체크하기 위한 배열
        int[] dx = {0, 0, 1, -1}; // 상하좌우
        int[] dy = {1, -1, 0, 0}; // 상하좌우
        Queue<int[]> q = new LinkedList<>(); // 큐 생성
        q.offer(new int[]{0, 0}); // 시작점
        visited[0][0] = 1; // 시작점 방문 체크

        
        while (!q.isEmpty()) {  // 큐가 빌 때까지 반복
            int[] now = q.poll();// 큐에서 하나 꺼내기
            int x = now[0]; // x좌표
            int y = now[1];// y좌표
            for (int i = 0; i < 4; i++) { // 상하좌우 이동
                int nx = x + dx[i]; // 다음 x좌표
                int ny = y + dy[i]; // 다음 y좌표
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) { // 맵을 벗어나지 않는지 체크
                    if (maps[nx][ny] == 1 && visited[nx][ny] == 0) { // 벽이 아니고 방문하지 않은 곳인지 체크
                        visited[nx][ny] = visited[x][y] + 1; // 방문한 곳을 체크
                        q.offer(new int[]{nx, ny}); // 큐에 추가
                    }
                }
            }
        }
        answer = visited[n - 1][m - 1] == 0 ? -1 : visited[n - 1][m - 1]; // 도착지점이 0이면 -1, 아니면 도착지점까지의 거리
        return answer; // 결과 반환
    }

    public static void main(String[] args) {

        int[][] maps ={
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1}
        };

        int [][] maps2 = {
            {1,0,1,1,1},
            {1,0,1,0,1},
            {1,0,1,1,1},
            {1,1,1,0,0},
            {0,0,0,0,1}
        };
        System.out.println(solution(maps2));

    }
}
