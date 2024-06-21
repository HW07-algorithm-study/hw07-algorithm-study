import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 효율적인해킹{
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    static int[] result;

    public static int dfs(int node) {
        int count = 1;  // 시작 노드 포함
        visited[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];
        result = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            adjList.get(b).add(a);
        }

        int maxCount = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1]; // 방문 배열 초기화
            result[i] = dfs(i);
            maxCount = Math.max(maxCount, result[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (result[i] == maxCount) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        scanner.close();
    }
}