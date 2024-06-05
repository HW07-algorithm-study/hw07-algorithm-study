#include <iostream>
// BOJ - 1300 kth Number
using namespace std;

typedef long long LL;
LL ans;

// 이 함수는 n x n 크기의 행렬에서 k번째 작은 수를 찾기 위한 재귀적 이진 탐색을 수행합니다.
void find_value(int n, int k, LL lo, LL hi) {
    // 중앙값 계산
    LL mid = (lo + hi) / 2;
    LL smalls = 0, temp;

    // 이진 탐색의 기본 조건 확인
    if (lo <= hi) {
        // mid보다 작거나 같은 수의 개수를 계산
        for (LL layer = 1; layer <= n; layer++) {
            temp = mid / layer;
            if (temp > n) temp = n; // 각 행에서 n을 초과하지 않도록 조정
            smalls += temp;
        }

        // 만약 lo와 hi가 같다면, 답을 찾은 것이므로 저장 후 반환
        if (lo == hi) { 
            ans = lo; 
            return; 
        }

        // k보다 작은 수의 개수가 k보다 적다면, 오른쪽 절반을 탐색
        if (smalls < k)
            find_value(n, k, mid + 1, hi);
        // 그렇지 않다면, 왼쪽 절반을 탐색
        else
            find_value(n, k, lo, mid);
    }
}

int main(void) {
    LL n, k;

    // 사용자로부터 n과 k를 입력받음
    cin >> n >> k;

    // n x n 크기의 행렬에서 k번째 작은 수를 찾기 위해 find_value 함수 호출
    find_value(n, k, 1, n * n);

    // 결과 출력
    cout << ans;

    return 0;
}
