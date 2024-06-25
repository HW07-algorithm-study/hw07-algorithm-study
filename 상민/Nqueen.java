import java.util.Scanner;

public class Nqueen {
    static int n;
    static int[] board;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n];  // board 배열 초기화
        dfs(0);
        System.out.println(cnt);

    }

    static int isPossible(int row) {
        for (int i = 0; i < row; i++) {
            if (board[row] == board[i] || row - i == Math.abs(board[row] - board[i])) {
                return 0;
            }
        }
        return 1;
    }

    static void dfs(int row) {
        if (row == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            board[row] = i;
            if (isPossible(row) == 1) {
                dfs(row + 1);
            }
        }

    }

}
