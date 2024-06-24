import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 효율적인해킹 {
    //BFS 풀이 
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    static int[] result;

    public static int bfs(int startNode) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
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
            visited = new boolean[N + 1]; 
            result[i] = bfs(i);
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