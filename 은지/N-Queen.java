import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek9663 { // N-Queen
    static int n;
    static int[] board;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n];
        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int d) {
        if(d == n) {
            count++;
            return;
        }
        for (int i=0;i<n;i++) {
            board[d] = i;
            if (check(d)) {
                dfs(d+1);
            }
        }
    }

    private static boolean check(int d) {
        for (int i=0;i<d;i++) {
            if (board[d] == board[i]) return false;
            else if (Math.abs(d-i) == Math.abs(board[d]-board[i])) return false;
        }
        return true;
    }
}
