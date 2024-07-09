import java.util.*;
import java.io.*;

public class BOJ15686치킨배달 {
    // 클래스 변수
    static int N, M; // N: 도시 크기, M: 선택할 치킨집 수
    static int[][] city; // 도시 격자를 나타내는 2차원 배열
    static List<int[]> houses = new ArrayList<>(); // 집 좌표를 저장하는 리스트
    static List<int[]> chickenShops = new ArrayList<>(); // 치킨집 좌표를 저장하는 리스트
    static int minChickenDistance = Integer.MAX_VALUE; // 최소 치킨 거리를 저장하는 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 입력을 위한 BufferedReader
        StringTokenizer st = new StringTokenizer(br.readLine()); // 첫 줄 입력을 토큰화

        // N (도시 크기)와 M (선택할 치킨집 수) 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N]; // 도시 격자 초기화

        // 도시 격자를 읽고, 집과 치킨집 위치를 식별
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); // 각 줄을 토큰화
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken()); // 도시 격자의 각 칸 읽기

                if (city[i][j] == 1) {
                    houses.add(new int[]{i, j}); // 집 좌표를 houses 리스트에 추가

                } else if (city[i][j] == 2) {
                    chickenShops.add(new int[]{i, j}); // 치킨집 좌표를 chickenShops 리스트에 추가
                }

            }
        }

        // 모든 치킨집 조합을 생성하여 최소 치킨 거리를 계산
        combination(new int[M], 0, 0);
        // 최소 치킨 거리를 출력
        System.out.println(minChickenDistance);
    }

    // 치킨집 조합을 생성하는 메소드
    // comb: 선택된 치킨집 인덱스를 저장하는 배열
    // start: 현재 조합의 시작 인덱스
    // depth: 현재 조합의 깊이
    public static void combination(int[] comb, int start, int depth) {
        // 조합이 완성된 경우 (M개의 치킨집이 선택된 경우)
        if (depth == M) {
            // 해당 조합에 대한 치킨 거리를 계산하고 최소 치킨 거리를 업데이트
            minChickenDistance = Math.min(minChickenDistance, getChickenDistance(comb));
            return; // 다음 조합 생성을 위해 리턴
        }

        // 'start' 인덱스부터 시작하여 치킨집을 선택
        for (int i = start; i < chickenShops.size(); i++) {
            comb[depth] = i; // 현재 인덱스의 치킨집을 선택
            combination(comb, i + 1, depth + 1); // 다음 치킨집 선택을 위해 재귀 호출
        }
    }

    // 특정 치킨집 조합에 대한 총 치킨 거리를 계산하는 메소드
    // comb: 선택된 치킨집 인덱스를 담고 있는 배열
    public static int getChickenDistance(int[] comb) {
        int totalDistance = 0; // 총 치킨 거리를 저장하는 변수

        // 각 집에 대해 계산
        for (int[] house : houses) {
            int hx = house[0], hy = house[1]; // 집의 좌표
            int minDistance = Integer.MAX_VALUE; // 최소 거리를 큰 값으로 초기화

            // 선택된 치킨집들 중 가장 가까운 치킨집까지의 거리를 찾음
            for (int i : comb) {
                int[] chicken = chickenShops.get(i); // 선택된 치킨집의 좌표
                int cx = chicken[0], cy = chicken[1]; // 치킨집의 좌표
                int distance = Math.abs(hx - cx) + Math.abs(hy - cy); // 맨해튼 거리 계산
                minDistance = Math.min(minDistance, distance); // 더 가까운 치킨집이 있으면 최소 거리 업데이트
            }

            totalDistance += minDistance; // 해당 집의 최소 거리를 총 거리합에 더함
        }

        return totalDistance; // 해당 조합의 총 치킨 거리 반환
    }
}
