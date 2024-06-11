import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // 콘솔로부터 입력을 읽기 위해 BufferedReader 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        // 장애물의 수와 동굴의 높이 입력 받기
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());


        // 아래에서부터의 장애물 배열과 위에서부터의 장애물 배열 초기화
        int[] down = new int[n / 2];
        int[] up = new int[n / 2];

//아래 위 아래 위 장애물 주어짐.


        // 장애물 높이 배열에 입력
        for (int i = 0; i < n / 2; i++) {
            down[i] = Integer.parseInt(br.readLine());
            up[i] = Integer.parseInt(br.readLine());
        }


        // 이진 탐색 효율을 위해 배열 정렬
        Arrays.sort(down);
        Arrays.sort(up);

        int minObstacles = n;  // 최소 장애물 수를 최대값으로 초기화
        int count = 0;         // 최소 장애물 수를 달성한 높이의 개수 초기화

        // 각 가능한 높이에 대해 반복
        for (int height = 1; height <= h; height++) {
            // 현재 높이에서 만나는 장애물 수 계산
            int obstacles = binarySearch(0, n / 2, height, down)
                    + binarySearch(0, n / 2, h - height + 1, up);

            // 최소 장애물 수와 해당 높이의 개수 업데이트
            if (minObstacles == obstacles) {
                count++;
            } else if (minObstacles > obstacles) {
                minObstacles = obstacles;
                count = 1;
            }
        }

        // 결과 출력: 최소 장애물 수와 이를 달성한 높이의 개수
        System.out.println(minObstacles + " " + count);
    }


    // 이진 탐색을 수행하여 주어진 높이보다 크거나 같은 배열 요소의 수를 찾음.

    // left  검색 범위의 시작 인덱스
    // right 검색 범위의 끝 인덱스
    // height 비교할 높이
    // arr 장애물 높이 배열
    // height보다 크거나 같은 요소의 수

    static int binarySearch(int left, int right, int height, int[] arr) {
        while (left < right) {  // 종료 조건: left가 right와 같아질 때

            int mid = (left + right) / 2;

            if (arr[mid] >= height) {
                right = mid;  // mid가 height 이상이면 오른쪽 경계를 mid로 이동
            } else {
                left = mid + 1;  // mid가 height 미만이면 왼쪽 경계를 mid + 1로 이동
            }
        }
        return arr.length - right;  // height 이상인 첫 위치 이후의 요소 수 반환
    }
}