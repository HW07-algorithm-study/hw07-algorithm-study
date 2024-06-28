import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] board;
    static boolean[][] attacked;
    static List<int[]> queens = new ArrayList<>();
    static List<int[]> knights = new ArrayList<>();
    static List<int[]> pawns = new ArrayList<>();

    // 8가지 방향: 상, 하, 좌, 우, 대각선 4방향
    static int[] dxQ = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dyQ = {0, 0, -1, 1, -1, 1, -1, 1};

    // 나이트의 이동 방향 8가지
    static int[] dxK = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dyK = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        N = sc.nextInt();
        M = sc.nextInt();

        board = new boolean[N][M];
        attacked = new boolean[N][M];

        int qCount = sc.nextInt();
        for (int i = 0; i < qCount; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            queens.add(new int[]{x, y});
            board[x][y] = true;
        }

        int kCount = sc.nextInt();
        for (int i = 0; i < kCount; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            knights.add(new int[]{x, y});
            board[x][y] = true;
        }

        int pCount = sc.nextInt();
        for (int i = 0; i < pCount; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            pawns.add(new int[]{x, y});
            board[x][y] = true;
        }

        // 퀸의 공격 범위를 표시
        for (int[] queen : queens) {
            markQueen(queen[0], queen[1]);
        }

        // 나이트의 공격 범위를 표시
        for (int[] knight : knights) {
            markKnight(knight[0], knight[1]);
        }

        // 안전한 칸의 수 계산
        int safeCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!board[i][j] && !attacked[i][j]) {
                    safeCount++;
                }
            }
        }

        // 결과 출력
        System.out.println(safeCount);
    }

    // 퀸의 공격 범위를 표시하는 함수
    static void markQueen(int x, int y) {
        for (int d = 0; d < 8; d++) {
            int nx = x;
            int ny = y;
            while (true) {
                nx += dxQ[d];
                ny += dyQ[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny]) break;
                attacked[nx][ny] = true;
            }
        }
    }

    // 나이트의 공격 범위를 표시하는 함수
    static void markKnight(int x, int y) {
        for (int d = 0; d < 8; d++) {
            int nx = x + dxK[d];
            int ny = y + dyK[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !board[nx][ny]) {
                attacked[nx][ny] = true;
            }
        }
    }
}
