import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWA1220 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(sc.nextLine());
            int[][] table = new int[n][n];
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                for(int j=0;j<n;j++){
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(n);
            int count = 0;
            for (int j=0;j<n;j++) {
                Stack<Integer> stack = new Stack<>();
                for (int i=0;i<n;i++) {
                    if (table[i][j] == 1) {
                        stack.add(1);
                    } else if (table[i][j] == 2) {
                        if (!stack.isEmpty()) {
                            table[i][j] = -1;
                            stack.clear();
                            count++;
                        }
                    }
                }
            }
            System.out.println("#"+test_case+" " +count);

        }
    }
}
