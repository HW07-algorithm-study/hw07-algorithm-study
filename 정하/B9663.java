package 정하;

public class B9663 {
    static int N;
    static int count = 0;

    public static void main(String[] args) {
        N = 8;
        int[] board = new int[N];
        Queen(board,0);
        System.out.println(count);
    }
    public static void Queen(int[] board, int row){
        if(row == N){
            count++;
            return;
        }

        for(int col = 0; col < N; col++){
            if(isSafe(board, row, col)){
                board[row] = col;
                Queen(board, row+1);
            }
        }
    }
    public static boolean isSafe(int[] board, int row, int col){
        for(int i = 0; i < row; i++){
            if(board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)){
                return false;
            }
        }
        return true;
    }
}


