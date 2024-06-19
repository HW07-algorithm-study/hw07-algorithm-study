import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek12852 { // 1로 만들기2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[1000001][4];
        for (int[] i:dp) {
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        dp[1][1] = 0;
        dp[1][2] = 0;
        dp[1][3] = 0;
        dp[2][1] = 1;
        dp[3][3] = 1;

        for (int i=4;i<=n;i++) {
            if (i%2==0) {
                dp[i][2] = Math.min(dp[i/2][1],Math.min(dp[i/2][2],dp[i/2][3]))+1;
            }
            if (i%3==0) {
                dp[i][3] = Math.min(dp[i/3][1],Math.min(dp[i/3][2],dp[i/3][3]))+1;
            }
            dp[i][1] = Math.min(dp[i-1][1],Math.min(dp[i-1][2],dp[i-1][3]))+1;
        }

        int i = n;
        System.out.println(Math.min(dp[n][1],Math.min(dp[n][2],dp[n][3])));
        System.out.print(i+" ");
        while (i > 1) {
            int min = dp[i][1];
            int index = 1;
            for (int j=2;j<4;j++) {
                if (min > dp[i][j]) {
                    min = dp[i][j];
                    index = j;
                }
            }
            if (index == 1) {
                i = i-1;
            }else {
                i /= index;
            }
            System.out.print(i+" ");
        }
    }
}