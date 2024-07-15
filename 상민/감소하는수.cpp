#include <algorithm>
#include <cstring>
#include <iostream>
#include <queue>
using namespace std;

int main() {
    vector<long long> v;
    queue<long long> q;
    int N;
    cin >> N;

    for (int i = 0; i <= 9; i++) {
        q.push(i);
        v.push_back(i);
    }
    while (!q.empty()) {
        long long num = q.front(); 
        int last = num % 10;        
        q.pop();

        for (int i = 0; i < last; i++) {
            long long newnum = num * 10 + i;  
            q.push(newnum);
            v.push_back(newnum);
        }
    }
    if (N >= v.size()) {
        cout << -1;
    } else {
        cout << v[N];
    }
    return 0;
}
