import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q2529 {
    static int N; // 부등호의 개수
    static boolean[] visited; // 숫자 사용 여부 체크 배열
    static String[] operators; // 부등호 배열
    static List<String> numbers = new ArrayList<>(); // 조건을 만족하는 숫자 조합 리스트

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 부등호 개수 입력
        operators = br.readLine().split(" "); // 부등호 입력

        // 0부터 9까지 숫자를 시작점으로 하여 DFS 탐색 시작
        for (int i = 0; i < 10; i++) {
            visited = new boolean[10]; // 방문 체크 배열 초기화
            visited[i] = true; // 시작 숫자를 방문으로 체크
            dfs(i, 0, String.valueOf(i)); // DFS 호출
        }

        // 조건을 만족하는 숫자 조합 리스트를 정렬하여 첫 번째 원소와 마지막 원소 출력
        Collections.sort(numbers);
        System.out.println(numbers.get(numbers.size() - 1)); // 최대값 출력
        System.out.println(numbers.get(0)); // 최소값 출력
    }



    //current 현재 숫자
    //depth 현재 깊이
    //num 현재까지의 숫자 조합

    static void dfs(int current, int depth, String num) {
        // 숫자 조합의 길이가 부등호 개수 + 1이면 조합 완료
        if (depth == N) {
            numbers.add(num);
            return;
        }

        // 0부터 9까지의 숫자를 시도
        for (int next = 0; next < 10; next++) {
            if (!visited[next]) {
                // 부등호 조건에 맞는지 확인
                if (operators[depth].equals("<") && current < next) {
                    visited[next] = true;
                    dfs(next, depth + 1, num + next); // 다음 숫자 시도
                    visited[next] = false; // 탐색 후 복구
                } else if (operators[depth].equals(">") && current > next) {
                    visited[next] = true;
                    dfs(next, depth + 1, num + next);
                    visited[next] = false;
                }
            }
        }
    }
}
