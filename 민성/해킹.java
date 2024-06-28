import java.util.*;

public class Main {
    static int n, m;	// 노드, 에지
    static boolean[] visit;		// 방문 배열
    static List<Integer>[] arr;		// 인접 리스트
    static int[] result;	// 신뢰도 배열
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new List[n + 1];
        result = new int[n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();		// 인접 리스트 초기화
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();	// 시작 노드
            int e = sc.nextInt();	// 종료 노드
            arr[s].add(e);
        }
        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            BFS(i);
        }
        int big = 0;
        for (int i = 1; i <= n; i++) {
            big = Math.max(big, result[i]);		// 최대값 탐색
        }
        for (int i = 1; i <= n; i++) {
            if (result[i] == big) {		// 최대값과 같다면 인덱스 출력
                System.out.print(i + " ");
            }
        }

    }
    static void BFS(int n) {

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = true;
        while (!q.isEmpty()) {		// 큐가 비어있을 때까지
            int num = q.poll();
            for (int i : arr[num]) {
                if (visit[i] == false) {	// 방문하지 않은 노드가 나왔을 경우
                    result[i]++;
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
    }
}