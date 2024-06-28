import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 덱 선언 (우선순위가 있는 BFS를 위해 사용)
    static Deque<int[]> deque = new ArrayDeque<>();
    // 방문 체크 배열
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int target = sc.nextInt();

        // 방문 체크 배열 초기화 (큰 값으로 채움)
        Arrays.fill(visited, Integer.MAX_VALUE);

        // 시작 위치와 초기 시간 0을 덱에 추가
        deque.add(new int[]{start, 0});
        visited[start] = 0; // 시작 위치 방문 체크

        // BFS 수행
        while (!deque.isEmpty()) {
            int[] current = deque.poll(); // 덱에서 현재 위치와 시간을 꺼냄
            int position = current[0]; // 현재 위치
            int time = current[1];     // 경과 시간

            // 목표 위치에 도달하면 경과 시간 출력 후 종료
            if (position == target) {
                System.out.println(time);
                break;
            }

            // *2 이동 (가중치 0)
            if (position * 2 <= 100000 && time < visited[position * 2]) {
                visited[position * 2] = time; // 방문 시간 갱신
                deque.addFirst(new int[]{position * 2, time}); // 덱의 앞에 추가
            }

            // +1 이동 (가중치 1)
            if (position + 1 <= 100000 && time + 1 < visited[position + 1]) {
                visited[position + 1] = time + 1; // 방문 시간 갱신
                deque.addLast(new int[]{position + 1, time + 1}); // 덱의 뒤에 추가
            }

            // -1 이동 (가중치 1)
            if (position - 1 >= 0 && time + 1 < visited[position - 1]) {
                visited[position - 1] = time + 1; // 방문 시간 갱신
                deque.addLast(new int[]{position - 1, time + 1}); // 덱의 뒤에 추가
            }
        }
    }
}
