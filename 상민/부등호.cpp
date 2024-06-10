#include <iostream>
#include <vector>

using namespace std;

int main() {
    int k;
    cin >> k;

    vector<char> input(k);
    vector<int> maxi(k + 1), mini(k + 1);

    // 최대값과 최소값 초기화
    maxi[0] = 9;
    mini[0] = 0;

    int increaseCount = 0, decreaseCount = 0;

    for (int i = 0; i < k; ++i) {
        cin >> input[i];

        if (input[i] == '<') {
            increaseCount++;
            decreaseCount = 0;
            maxi[i + 1] = maxi[i];

            for (int j = i; j >= i + 1 - increaseCount; --j) {
                maxi[j]--;
            }

            mini[i + 1] = i + 1;
        } else if (input[i] == '>') {
            increaseCount = 0;
            decreaseCount++;
            maxi[i + 1] = 9 - (i + 1);
            mini[i + 1] = mini[i];

            for (int j = i; j >= i + 1 - decreaseCount; --j) {
                mini[j]++;
            }
        }
    }

    for (int i = 0; i <= k; ++i) {
        cout << maxi[i];
    }
    cout << "\n";

    for (int i = 0; i <= k; ++i) {
        cout << mini[i];
    }
    cout << "\n";

    return 0;
}
