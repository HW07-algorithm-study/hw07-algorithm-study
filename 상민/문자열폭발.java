import java.util.*;
public class 문자열폭발 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s1.length(); i++) {
            result.append(s1.charAt(i));
            if (result.length() >= s2.length()) {
                if (result.substring(result.length() - s2.length()).equals(s2)) {
                    result.delete(result.length() - s2.length(), result.length());
                }
            }
        }

        if (result.length() > 0) {
            System.out.println(result.toString());
        } else {
            System.out.println("FRULA");
        }

        scanner.close();
    }
}

    

