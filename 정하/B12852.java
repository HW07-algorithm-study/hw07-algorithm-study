package 정하;

import java.util.*;

public class B12852 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int[] count = new int[N + 1];  // count[i]는 i를 1로 만드는 최소 연산 수
        int[] record = new int[N + 1];  // record[i]는 i에서 다음으로 이동할 숫자

        // DP 테이블을 채움
        for (int i = 2; i <= N; i++) {
            count[i] = count[i - 1] + 1;  // 기본적으로 count[i]는 count[i-1] + 1 (1을 빼는 경우)
            record[i] = i - 1;  // 이때 record[i]는 i-1

            if (i % 2 == 0 && count[i] > count[i / 2] + 1) {  // i가 2로 나누어 떨어질 때
                count[i] = count[i / 2] + 1;  // count[i/2] + 1이 더 작으면 count[i] 갱신
                record[i] = i / 2;  // record[i]를 i/2로 설정
            }

            if (i % 3 == 0 && count[i] > count[i / 3] + 1) {  // i가 3으로 나누어 떨어질 때
                count[i] = count[i / 3] + 1;  // count[i/3] + 1이 더 작으면 count[i] 갱신
                record[i] = i / 3;  // record[i]를 i/3로 설정
            }
        }

        System.out.println(count[N]);  // N을 1로 만드는 최소 연산 수 출력

        StringBuilder sb = new StringBuilder();  // 결과 경로를 저장할 StringBuilder 생성
        while (N > 0) {  // N이 0보다 클 때까지 반복
            sb.append(N).append(" ");  // 현재 N을 추가
            N = record[N];  // N을 record[N]으로 갱신 (경로를 따라감)
        }

        System.out.println(sb.toString().trim());  // 결과 경로를 문자열로 변환하여 출력
    }
}
