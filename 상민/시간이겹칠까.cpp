#include <iostream>
#define MAX 1000001
using namespace std;

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);

    int n, s, e;
    int dp[MAX];
    int sum_arr[MAX];
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> s >> e;
        dp[s]++;
        dp[e + 1]--; //각 좌석은 사용이 종료되는 시각에 곧바로 선택될 수 없다.
    }

    for (int i = 1; i < MAX; i++) {
        sum_arr[i] = sum_arr[i - 1] + dp[i]; 
    }
    
    int q;
    cin >> q;
    while (q--) {
        int time;
        cin >> time;
        cout << sum_arr[time] << '\n';
    }
}
