package 스터디패키지.백준.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ2503숫자야구 {
    static ArrayList<Integer> candidates = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 가능한 모든 후보 생성
        generateCandidates();

        // 추측 , 스트라이크 , 볼 처리
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int guess = Integer.parseInt(input[0]);
            int strikes = Integer.parseInt(input[1]);
            int balls = Integer.parseInt(input[2]);

            // 후보들을 검사하여 현재 입력한 guess가 가능한지 판단
            filterCandidates(guess, strikes, balls);
        }

        // 가능한 후보 수 출력
        System.out.println(candidates.size());
    }

    // 가능한 모든 세 자리 수 생성
    static void generateCandidates() {
        for (int num = 123; num <= 987; num++) {
            int firstDigit = num / 100;
            int secondDigit = (num / 10) % 10;
            int thirdDigit = num % 10;

            // 중복되지 않고 각 자리 숫자가 0이 아니어야 함
            if (firstDigit != secondDigit && secondDigit != thirdDigit && thirdDigit != firstDigit
                    && firstDigit != 0 && secondDigit != 0 && thirdDigit != 0) {
                candidates.add(num);
            }
        }
    }

    // 후보들을 검사하여 현재 입력한 guess가 가능한지 판단
    static void filterCandidates(int guess, int strikes, int balls) {
        ArrayList<Integer> newCandidates = new ArrayList<>();

        for (int candidate : candidates) {
            if (isPossible(guess, candidate, strikes, balls)) {
                newCandidates.add(candidate);
            }
        }

        candidates = newCandidates; // 가능한 후보들을 업데이트
    }

    // 현재 후보가 가능한지 판단
    static boolean isPossible(int guess, int candidate, int strikes, int balls) {
        int guessDigit1 = guess / 100;
        int guessDigit2 = (guess / 10) % 10;
        int guessDigit3 = guess % 10;

        int candidateDigit1 = candidate / 100;
        int candidateDigit2 = (candidate / 10) % 10;
        int candidateDigit3 = candidate % 10;

        int strikeCount = 0;
        int ballCount = 0;

        // 스트라이크 개수 계산
        if (guessDigit1 == candidateDigit1) strikeCount++;
        if (guessDigit2 == candidateDigit2) strikeCount++;
        if (guessDigit3 == candidateDigit3) strikeCount++;

        // 볼 개수 계산
        if (guessDigit1 == candidateDigit2 || guessDigit1 == candidateDigit3) ballCount++;
        if (guessDigit2 == candidateDigit1 || guessDigit2 == candidateDigit3) ballCount++;
        if (guessDigit3 == candidateDigit1 || guessDigit3 == candidateDigit2) ballCount++;

        // 주어진 스트라이크, 볼과 일치하는지 검사
        return (strikeCount == strikes && ballCount == balls);
    }
}
