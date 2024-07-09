import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baek1038 { // 감소하는 수
    static List<Long> numbers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n < 10) {
            System.out.println(n);
            return;
        } else if (n >= 1023) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < 10; i++) {
            search(1, i);
        }
        Collections.sort(numbers);
        System.out.println(numbers.get(n));

    }
    private static void search(int length, long cur) {
        System.out.println("index = " + length);
        System.out.println("acc = " + cur);
        if(length > 10) return;
        numbers.add(cur);
        // 마지막 자릿수보다 작은 것만 i 로 더해주면서 감소하는 수 생성
        for (int i = 0; i < cur % 10; i++) {
            search(length + 1, cur * 10 + i);
        }
    }
}