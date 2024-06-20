import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        System.out.println(removeString(str, bomb));

    }

    public static String removeString(String str, String bomb) {

        Stack<Character> stack = new Stack<>(); // char형 자료구조 선언

        int bombLen = bomb.length(); // 폭발 문자열의 길이 저장
        // str 문자열을 문자열 길이만큼 한 글자씩 짤라서 순회하면서
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i)); // 현재 문자를 스택에 추가

            // 스택의 크기가 폭발 문자열의 길이 이상일때만 진입 -> 여전히 데이터를 넣고 있는 상태
            if (stack.size() >= bombLen) {
                // 스택의 마지막 부분이 폭발 문자열과 일치하는지 확인
                boolean check = true;
                //하나 하나 씩 넣을 때 마다 아래 for문에서 비교
                for (int j = 0; j < bombLen; j++) {
                    // 스택의 마지막 부분과 폭발 문자열을 비교
                    if (stack.get(stack.size() - bombLen + j) != bomb.charAt(j)) {
                        check = false;
                        break; // 일치하지 않으면 비교 중단하고 탈출
                    }
                }
                // 폭발 문자열과 일치하면 34라인의 if문에 진입하지 않으면 match는 true
                if (check) {
                    // 폭발 문자열 길이만큼 스택에서 제거 -> 이 과정을 거쳐서 폭발 문자열은 다 제거된다.
                    for (int j = 0; j < bombLen; j++) {
                        stack.pop();
                    }
                }
            }
        }
        // 문자열로 변환
        StringBuilder ans = new StringBuilder();
        for (char ch : stack) {
            ans.append(ch);
        }
        // 남은 문자가 없으면 "FRULA" 반환
        return ans.length() == 0 ? "FRULA" : ans.toString();

    }
}
