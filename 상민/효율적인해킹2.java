import java.io.*;
import java.util.*;

public class 효율적인해킹2 {
    static int n, m;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int[] result;
    static int maxDepth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[b].add(a); // 간선의 방향을 반대로 저장
        }

        result = new int[n + 1];
        maxDepth = 0;

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            int depth = bfs(i);
            result[i] = depth;
            maxDepth = Math.max(maxDepth, depth);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (result[i] == maxDepth) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }

    public static int bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int neighbor : adjList[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return count;
    }
}
