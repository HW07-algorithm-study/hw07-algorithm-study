import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1182 { // 부분수열의 합
    static int[] nums;
    static int s;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        tracking(0, 0);
        if (s == 0) {
            count--;  // 공집합을 제외
        }
        System.out.println(count);
    }

    static void tracking(int sum, int d) {
        if (d == nums.length) {
            if (sum == s) {
                count++;
            }
            return;
        }
        // 현재 원소를 포함하는 경우
        tracking(sum + nums[d], d + 1);
        // 현재 원소를 포함하지 않는 경우
        tracking(sum, d + 1);
    }
}