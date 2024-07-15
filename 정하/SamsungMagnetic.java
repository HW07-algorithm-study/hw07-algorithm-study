package 정하;

import java.util.Scanner;

public class SamsungMagnetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++){
            int N = sc.nextInt();
            int[][] field = new int[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    field[i][j] = sc.nextInt();
                }
            }
            int count = 0;
            for(int j = 0; j < N; j++){
                boolean conflict = false; // N극이 있으면 충돌한다고 가정
                for(int i = 0; i < N; i++){
                    if(field[i][j]==1){
                        conflict = true; // 열에 N극이 있는 경우이므로 True 할당
                    } else if(field[i][j] == 2 && conflict){ // 열에 S극이 있고(2) N극이 있는 상황
                        count++;    // 교착 상태이므로 count 값 증가
                        conflict = false;  // 각각 다른 곳에서 충돌하면 다른 교착 상태이므로 False 재할당
                    }
                }
            }
            System.out.println("#" + test_case + " " + count);
        }
        sc.close();
    }
}
