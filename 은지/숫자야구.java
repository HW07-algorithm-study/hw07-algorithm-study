import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek2503 { // 숫자 야구
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] bool = new boolean[1000];
        Arrays.fill(bool,true);
        StringTokenizer st;
        for (int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String number = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            for (int num = 123;num<1000;num++) {
                int first = num/100;
                int second = num/10%10;
                int third = num%10;
                if (first==second||second==third||first==third||second==0||third==0) {
                    bool[num]= false;
                    continue;
                }
                if (!bool[num]) continue;
                int sCount = 0;
                int bCount = 0;
                for (int index = 0;index<3;index++) {
                    if (number.contains(Character.toString(String.valueOf(num).charAt(index)))) {
                        if (number.charAt(index) == String.valueOf(num).charAt(index)) {
                            sCount++;
                        }else bCount++;
                    }
                }
                if (sCount==strike&&bCount==ball) {
                    bool[num] = true;
                }else bool[num] = false;
            }
        }
        int count = 0;
        for (int num = 123;num<1000;num++) {
            if (bool[num]) {
                count++;
            }
        }
        System.out.println(count);

    }
}