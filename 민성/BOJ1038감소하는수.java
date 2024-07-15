package 스터디패키지.백준.브루트포스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ1038감소하는수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        if (N > 1022) { // 감소하는 수가 총 1023개이므로, N이 1022를 넘으면 존재하지 않음
            System.out.println(-1);
            return;
        }

        ArrayList<Long> decreasingNumbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            generateDecreasingNumbers(i, decreasingNumbers);
        }

        Collections.sort(decreasingNumbers);

        System.out.println(decreasingNumbers.get(N));
    }

    // 감소하는 수를 생성하는 함수
    private static void generateDecreasingNumbers(long num, ArrayList<Long> list) {
        list.add(num);

        long lastDigit = num % 10;
        for (int i = 0; i < lastDigit; i++) {
            generateDecreasingNumbers(num * 10 + i, list);
        }
    }
}
