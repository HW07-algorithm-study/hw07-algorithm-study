import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek3020 { //개똥벌레
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] s = new int[h+1];
        int[] j = new int[h+1];

        int[] count = new int[h+1];

        for (int i=0;i<n/2;i++) {
            s[Integer.parseInt(br.readLine())]++;
            j[Integer.parseInt(br.readLine())]++;
        }

        for (int i=h-2;i>0;i--) {
            s[i] = s[i+1] + s[i];
            j[i] = j[i+1] + j[i];
        }
        for (int i=1;i<=h;i++) {
            count[i] = s[i] + j[h-i+1];
        }
        System.out.println(Arrays.toString(count));
        Arrays.sort(count);
        int res = 0;
        for (int i=1;i<=h;i++) {
            if (count[i]!=count[1]) {
                break;
            }
            res++;
        }
        System.out.println(Arrays.toString(count));
        System.out.println(count[1]+ " "+res);
    }
}
