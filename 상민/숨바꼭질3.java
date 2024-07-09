import java.util.*;

public class 숨바꼭질3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        // 가장 빠른 시간을 구하라
        int answer2 = bfs2(start, end);
        System.out.println(answer2);
    }

    static int bfs2(int start, int end) {
        if (start == end) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int time = current[1];

            // 우선적으로 두 배 이동
            if (position * 2 <= 100000 && !visited[position * 2]) {
                if (position * 2 == end) {
                    return time;
                }
                queue.add(new int[]{position * 2, time});
                visited[position * 2] = true;
            }

            // -1 이동
            if (position - 1 >= 0 && !visited[position - 1]) {
                if (position - 1 == end) {
                    return time + 1;
                }
                queue.add(new int[]{position - 1, time + 1});
                visited[position - 1] = true;
            }

            // +1 이동
            if (position + 1 <= 100000 && !visited[position + 1]) {
                if (position + 1 == end) {
                    return time + 1;
                }
                queue.add(new int[]{position + 1, time + 1});
                visited[position + 1] = true;
            }
        }
        return -1;  // 도달 불가능한 경우
    }
}
