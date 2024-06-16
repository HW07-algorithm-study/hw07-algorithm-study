import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int[][] cctv = { {}, {1}, {1, 3}, {0, 1}, {0, 1, 3}, {0, 1, 2, 3} };
    static int N, M, CNT;
    static int[][] arr;
    static List<int[]> lst = new ArrayList<>();
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N + 2][M + 2];
        for (int i = 0; i < N + 2; i++) {
            for (int j = 0; j < M + 2; j++) {
                arr[i][j] = 6;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr[i][j] = sc.nextInt();
                if (1 <= arr[i][j] && arr[i][j] <= 5) {
                    lst.add(new int[]{i, j});
                }
            }
        }

        CNT = lst.size();
        ans = N * M;

        dfs(0, new ArrayList<>());

        System.out.println(ans);
    }

    static void dfs(int n, List<Integer> tlst) {
        if (n == CNT) {
            ans = Math.min(ans, cal(tlst));
            return;
        }

        for (int i = 0; i < 4; i++) {
            List<Integer> newTlst = new ArrayList<>(tlst);
            newTlst.add(i);
            dfs(n + 1, newTlst);
        }
    }

    static int cal(List<Integer> tlst) {
        int[][] v = new int[N + 2][M + 2];

        for (int i = 0; i < CNT; i++) {
            int[] position = lst.get(i);
            int si = position[0];
            int sj = position[1];
            int rot = tlst.get(i);
            int type = arr[si][sj];

            for (int dr : cctv[type]) {
                dr = (dr + rot) % 4;
                int ci = si;
                int cj = sj;

                while (true) {
                    ci += di[dr];
                    cj += dj[dr];
                    if (arr[ci][cj] == 6) {
                        break;
                    }
                    v[ci][cj] = 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (arr[i][j] == 0 && v[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
