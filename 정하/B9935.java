package 정하;

import java.util.Scanner;
import java.util.Stack;

public class B9935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String key = sc.nextLine();
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < word.length(); i++){
            s.push(word.charAt(i));
//            스택에 key의 크기보다 많이 들어가 있을 때만
            if(s.size() >= key.length()){
//                폭발시킨다고 가정
                boolean bomb = true;
                for(int j = 0; j < key.length(); j++){
//                    mirkovC4nizCC44의 경우 mirkoveC4까지 들어갔을 때
//                    index(9-2+1)인 7부터 비교-> C
//                    7번 인덱스가 같으므로 아래 if문 진행x
//                    8번 인덱스 4이므로 한개 더 아래에 있는 if문
                    if (s.get(s.size() - key.length() + j)!= key.charAt(j)){
                        bomb = false;
                        break;
                    }
                } // 여기서 key의 길이만큼 pop해줌
                if(bomb){
                    for(int k = 0; k < key.length(); k++){
                        s.pop();
                    }
                }
            }
        } // 출력을 위해 StringBuilder에 저장함
        StringBuilder sb = new StringBuilder();
        for(char c: s){
            sb.append(c);
        }
        if(sb.length()==0){
            System.out.println("FRULA");
        } else{
            System.out.println(sb);
        }


//        메모리 초과 --> Stack 사용?
//        if (key.isEmpty()) {
//            System.out.println("key 값이 빈 문자열입니다.");
//            return;
//        }
//        while (true) {
//            StringBuilder sb = new StringBuilder(word.replace(key, "!"));
//            if (sb.indexOf("!") == -1) {
//                if(sb.length()==0){
//                    System.out.println("FRULA");
//                    break;
//                } else{
//                    System.out.println(sb);
//                    break;
//                }
//            } else {
//                sb.deleteCharAt(sb.indexOf("!"));
//                word = sb.toString();
//            }
//        }
    }

}
