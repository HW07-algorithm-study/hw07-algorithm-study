import java.util.*;

public class 팰린드롬만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'A']++;
        }
        int odd = 0;
        for(int i = 0; i < 26; i++){
            if(arr[i] % 2 == 1){
                odd++;
            }
        }
        if(odd > 1){
            System.out.println("I'm Sorry Hansoo");
        }else{
            String front = "";
            String back = "";
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < arr[i]/2; j++){
                    front += (char)(i + 'A');
                    back = (char)(i + 'A') + back;
                }
            }
            if(odd == 1){
                for(int i = 0; i < 26; i++){
                    if(arr[i] % 2 == 1){
                        System.out.println(front + (char)(i + 'A') + back);
                        break;
                    }
                }
            }else{
                System.out.println(front + back);
            }
        }
    }
}
