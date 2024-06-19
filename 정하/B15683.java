package 정하;

import java.util.*;

public class B15683 {
    static int N, M, minBlindSpot;
    static int[][] map, copyMap;
    static List<CCTV> cctvs = new ArrayList<>();

    // 상, 우, 하, 좌 방향 벡터
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    // 각 CCTV 타입별 가능한 방향 조합
    static int[][][] directions = {
            {},
            { { 0 }, { 1 }, { 2 }, { 3 } },                  // 1번 CCTV
            { { 0, 2 }, { 1, 3 } },                          // 2번 CCTV
            { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } },      // 3번 CCTV
            { { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 } }, // 4번 CCTV
            { { 0, 1, 2, 3 } }                               // 5번 CCTV
    };

    static class CCTV {
        int x, y, type;

        CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();  // 행의 수
        M = sc.nextInt();  // 열의 수
        map = new int[N][M];

        // 지도 입력과 CCTV 위치 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvs.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        minBlindSpot = Integer.MAX_VALUE;  // 최소 사각지대 초기화
        dfs(0);  // 백트래킹 시작

        System.out.println(minBlindSpot);  // 최소 사각지대 출력
        sc.close();
    }

    static void dfs(int depth) {
        // 모든 CCTV를 처리한 경우 사각지대 계산
        if (depth == cctvs.size()) {
            minBlindSpot = Math.min(minBlindSpot, countBlindSpots());
            return;
        }

        CCTV cctv = cctvs.get(depth);
        int type = cctv.type;

        // 해당 CCTV의 모든 가능한 방향 조합을 시도
        for (int[] direction : directions[type]) {
            copyMap = copyMap(map);  // 맵 상태 복사
            for (int d : direction) {
                monitor(cctv.x, cctv.y, d);  // 해당 방향으로 감시
            }
            dfs(depth + 1);  // 다음 CCTV로 넘어감
            map = copyMap(map); // 맵 상태 복원
        }
    }

    static void monitor(int x, int y, int d) {
        int nx = x;
        int ny = y;

        // 지정된 방향으로 계속 감시
        while (true) {
            nx += dx[d];
            ny += dy[d];

            // 맵을 벗어나거나 벽을 만난 경우 종료
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 6) break;
            // 빈 칸을 감시한 경우 표시
            if (map[nx][ny] == 0) {
                map[nx][ny] = 7;
            }
        }
    }

    // 사각지대(빈 칸)의 개수를 세는 함수
    static int countBlindSpots() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    // 맵을 복사하는 함수
    static int[][] copyMap(int[][] original) {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(original[i], 0, newMap[i], 0, M);
        }
        return newMap;
    }
}
