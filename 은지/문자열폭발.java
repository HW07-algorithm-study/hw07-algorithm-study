import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Baek9935 { // 문자열 폭발
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String explosion = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++) {
            stack.push(s.charAt(i));
            if (stack.size() >= explosion.length()) {
                boolean flag = true;
                for (int j=0;j<explosion.length();j++) {
                    if(stack.get(stack.size()-explosion.length()+j) != explosion.charAt(j)){
                        flag = false;
                    }
                }
                if (flag) {
                    for (int j=0;j<explosion.length();j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        System.out.println(sb);

    }

}