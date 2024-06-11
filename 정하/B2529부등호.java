package 정하;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2529부등호 {
    static int k; // 부등호의 개수
    static char[] sign; // 부등호 배열
    static boolean[] check = new boolean[10]; // 숫자 사용 여부를 체크하는 배열
    static List<String> answer = new ArrayList<>(); // 결과를 저장할 리스트

    public static void main(String[] args) {
        // 입력을 받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt(); // 부등호의 개수 입력 받음
        sign = new char[k];
        for (int i = 0; i < k; i++) {
            sign[i] = sc.next().charAt(0); // 부등호 입력 받아 배열에 저장
        }
        sc.close(); // 입력 종료

        findNum(0, ""); // 백트래킹 함수 호출하여 가능한 숫자 조합 찾기
        Collections.sort(answer); // 결과 리스트 정렬

        System.out.println(answer.get(answer.size()-1));    // 최댓값
        System.out.println(answer.get(0));                  // 최솟값
    }

    // 백트래킹 함수: 가능한 모든 숫자 조합을 생성
    static void findNum(int index, String current) {
        // k + 1개의 숫자를 모두 선택했을 때
        if (index == k + 1) {
            // 현재 숫자 조합이 부등호 조건을 만족하는지 확인
            if (isValid(current)) {
                answer.add(current); // 유효한 경우 결과 리스트에 추가
            }
            return;
        }

        // 0부터 9까지의 숫자를 사용하여 조합 생성
        for (int i = 0; i <= 9; i++) {
            if (!check[i]) { // 현재 숫자가 사용되지 않았다면
                check[i] = true; // 숫자를 사용 상태로 변경
                findNum(index + 1, current + i); // 다음 숫자 조합 생성
                check[i] = false; // 숫자 사용 상태 되돌리기
            }
        }
    }

    // 유효성 검사 함수: 현재 생성된 숫자 조합이 부등호 조건을 만족하는지 확인
    static boolean isValid(String numStr) {
        // 각 부등호 조건을 확인
        for (int i = 0; i < k; i++) {
            if (sign[i] == '<') { // 부등호가 '<'일 때
                if (numStr.charAt(i) >= numStr.charAt(i + 1)) {
                    return false; // 조건을 만족하지 않으면 false 반환
                }
            } else if (sign[i] == '>') { // 부등호가 '>'일 때
                if (numStr.charAt(i) <= numStr.charAt(i + 1)) {
                    return false; // 조건을 만족하지 않으면 false 반환
                }
            }
        }
        return true; // 모든 조건을 만족하면 true 반환
    }
}

