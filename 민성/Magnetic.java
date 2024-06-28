import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            // 배열의 크기 N을 입력받기
            int N = Integer.parseInt(sc.nextLine());
            int[][] map = new int[N][N]; // N x N 크기의 2차원 배열 선언

            // 2차원 배열 입력 받기
            for (int i = 0; i < N; i++) {
                // 한 줄을 읽어와서 공백으로 구분하여 배열로 변환
                String[] line = sc.nextLine().split(" ");
                for (int j = 0; j < N; j++) {
                    // 각 값을 정수로 변환하여 배열에 저장
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }

            int cnt = 0; // 1 다음에 2가 나오는 쌍의 개수를 세기 위한 변수
            // 열 단위로 순회
            for (int j = 0; j < N; j++) {
                int previous = 0; // 이전 값을 저장하기 위한 변수
                // 행 단위로 순회
                for (int i = 0; i < N; i++) {
                    int n = map[i][j]; // 현재 위치의 값 가져오기
                    // 0이 아닌 값에 대해서만 처리
                    if (n != 0) {
                        // 현재 값이 2이고 이전 값이 1이면 쌍을 찾은 것
                        if (n == 2 && previous == 1) {
                            cnt++; // 쌍의 개수 증가
                        }
                        previous = n; // 현재 값을 이전 값으로 저장
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, cnt);
        }
    }
}
