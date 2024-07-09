#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n;
    cin >> n;
    bool solution[988] = {false}; 
    string tmp;

    for (int i = 123; i <= 987; i++) {
        tmp = to_string(i);
        if (tmp[0] != tmp[1] && tmp[1] != tmp[2] && tmp[0] != tmp[2] && tmp[0] != '0' && tmp[1] != '0' && tmp[2] != '0') {
            solution[i] = true;
        }
    }

    int num, str, ball;
    string compare1, compare2;
    int s_count, b_count;

    for (int i = 1; i <= n; i++) {
        cin >> num >> str >> ball;

        for (int j = 123; j <= 987; j++) {
            s_count = 0;
            b_count = 0;

            if (solution[j]) {
                compare1 = to_string(num);
                compare2 = to_string(j);

                for (int a = 0; a < 3; a++) {
                    for (int b = 0; b < 3; b++) {
                        if (a == b && compare1[a] == compare2[b]) s_count++;
                        if (a != b && compare1[a] == compare2[b]) b_count++;
                    }
                }

                if (s_count != str || b_count != ball) solution[j] = false;
            }
        }
    }

    int cnt = 0;
    for (int i = 123; i <= 987; i++) {
        if (solution[i]) cnt++;
    }

    cout << cnt;
}
