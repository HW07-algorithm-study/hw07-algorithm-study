import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] A;
    static int[] count;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        A = new List[n+1];
        count = new int[n+1];
        visited = new boolean[n+1];
        for (int i=1;i<=n;i++) {
            A[i] = new ArrayList<>();
        }
        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
        }
        for (int i=1;i<=n;i++) {
            visited = new boolean[n+1];
            bfs(i);
        }
        int max = -1;
        for (int i=1;i<=n;i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=1;i<=n;i++) {
            if (count[i] == max) bw.write(i+" ");
        }
        bw.flush();
    }
    static void bfs(int s) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Integer i : A[current]) {
                if (!visited[i]){
                    visited[i] = true;
                    count[i]++;
                    queue.add(i);
                }
            }
        }
    }
}