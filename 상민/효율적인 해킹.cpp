#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

vector<vector<int>> adjList;
vector<int> visited;
vector<int> result;

int dfs(int node) {
    int count = 1;  // 시작 노드 포함
    visited[node] = 1;

    for (int neighbor : adjList[node]) {
        if (!visited[neighbor]) {
            count += dfs(neighbor);
        }
    }
    return count;
}

int main() {
    int N, M;
    cin >> N >> M;

    adjList.resize(N + 1);
    visited.resize(N + 1);
    result.resize(N + 1, 0);

    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        adjList[b].push_back(a);
    }

    int maxCount = 0;
    for (int i = 1; i <= N; i++) {
        fill(visited.begin(), visited.end(), 0);
        result[i] = dfs(i);
        maxCount = max(maxCount, result[i]);
    }

    for (int i = 1; i <= N; i++) {
        if (result[i] == maxCount) {
            cout << i << " ";
        }
    }
    cout << endl;

    return 0;
}
