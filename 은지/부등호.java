import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baek2529 { // 부등호
    static boolean[] visited;
    static String[] b;
    static int k;
    static HashSet<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        b = new String[k];
        visited = new boolean[10];
        set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<k;i++) {
            b[i] = st.nextToken();
        }
        dfs("",new int[]{0,1,2,3,4,5,6,7,8,9},0);
        for (String s : set) {
            StringBuilder sb = new StringBuilder();
            for (int i =0;i<s.length();i++) {
                sb.append(s.charAt(i));
                if (i < b.length)
                    sb.append(b[i]);
            }
        }
        System.out.println(Collections.max(set));
        System.out.println(Collections.min(set));

    }
    public static void dfs(String numbers, int[] hubo, int depth) {
        if (depth == k+1) {
            set.add(numbers);
            return;
        }
        for (int i=0; i <hubo.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if (!numbers.isEmpty()){
                    if (b[depth-1].equals("<")) {
                        if((int) numbers.charAt(depth-1) -'0' < hubo[i]) {
                            dfs(numbers+hubo[i] ,hubo, depth + 1);
                        }
                    }else {
                        if((int) numbers.charAt(depth-1) -'0' > hubo[i]) {
                            dfs(numbers+hubo[i] ,hubo, depth + 1);
                        }
                    }
                }else {
                    dfs(numbers+hubo[i] ,hubo, depth + 1);
                }
                visited[i] = false;
            }
        }
    }
}
