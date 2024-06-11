package 정하;
import java.util.Arrays;
import java.util.LinkedList;

class P_Boat {
    public int solution(int[] people, int limit) {
        // 효율적인 계산을 위해 정렬
        Arrays.sort(people);
        // 마지막 값과 처음 값을 사용하기 위해 LinkedList를 사용
        LinkedList<Integer> tempList = new LinkedList<>();
        // 정렬된 데이터 LinkedList에 저장
        for (int person : people) {
            tempList.add(person);
        }

        int cnt = 0;
        // 리스트가 빌 때까지 반복문
        while (!tempList.isEmpty()) {
            // 정렬된 데이터이므로 리스트의 첫번째가 최솟값, 마지막이 최댓값
            int min = tempList.getFirst();
            int max = tempList.getLast();
            // 가장 효율적인 방식은 가장 무거운 사람을 먼저 태우고
            // 1명을 더 태워서 보내는 것이 효율적이므로
            if (max + min <= limit) {
                // 1명만 남는 경우 예외처리
                if (tempList.size() == 1) {
                    tempList.removeLast();
                    cnt++;
                    // 2명 태웠으니 처음과 마지막 인덱스 제거
                } else {
                    tempList.removeLast();
                    tempList.removeFirst();
                    cnt++;
                }
                // 무거운 사람 먼저 태워서 보내기
            } else {
                tempList.removeLast();
                cnt++;
            }
        }
        return cnt;
    }
}

