#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, x, window_sum = 0;
    cin >> n >> x;
    vector<int> v(n);

    for (int i = 0; i < n; i++) {
        cin >> v[i];
    }

    for (int i = 0; i < x; i++) {  // x까지의 합
        window_sum += v[i];
    }

    int max_sum = window_sum;
    int cnt = 1;

    for (int i = x; i < n; i++) {       // 슬리이딩 윈도우
        window_sum += v[i] - v[i - x];  // 이전 값 빼고 새로운 값 더하기

        if (window_sum > max_sum) {
            max_sum = window_sum;
            cnt = 1;
        } else if (window_sum == max_sum) {
            cnt++;
        }
    }

    if (max_sum == 0) {
        cout << "SAD";
    } else {
        cout << max_sum << "\n" << cnt;
    }

    return 0;
}
