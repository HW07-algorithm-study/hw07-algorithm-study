import java.util.Scanner;

public class Main {
    static int[] num; // 수열의 원소를 담을 배열
    private static int N; // 수열의 크기
    private static int S; // 목표 합
    private static int answer = 0; // 합이 S인 부분수열의 개수를 세기 위한 변수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 수열의 크기 입력
        S = sc.nextInt(); // 목표 합 입력
        num = new int[N]; // 수열 배열 초기화
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt(); // 수열의 원소 입력
        }
        dfs(0, 0); // DFS 호출
        if (S == 0) {
            System.out.println(answer - 1); // 공집합을 제외하기 위해 -1
        } else {
            System.out.println(answer);
        }
        sc.close();
    }

    // DFS를 사용하여 부분수열을 탐색하는 함수
    private static void dfs(int depth, int sum) {
        if (depth == N) {
            // 기저 조건: 모든 원소를 탐색한 경우
            if (sum == S) {
                answer++; // 현재 부분수열의 합이 S와 같다면 카운트를 증가
            }
            return;
        }
        // 현재 인덱스의 원소를 포함하는 경우
        dfs(depth + 1, sum + num[depth]);
        // 현재 인덱스의 원소를 포함하지 않는 경우
        dfs(depth + 1, sum);
    }
}
