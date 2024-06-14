#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>
using namespace std;

int n, m, result = 100;
int board[9][9];
int dx[4] = {-1, 1, 0, 0}; // 상 하 좌 우
int dy[4] = {0, 0, -1, 1};
vector<pair<int, int>> v; // cctv 위치 저장

int blindSpot(){ // 사각지대
    int cnt = 0;
    for(int i = 0; i < n; i++)
        for(int j = 0; j < m; j++)
            if(board[i][j] == 0)
                cnt++;
    return cnt;
}

void changeBoard(queue<pair<int, int>> q, int val){
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        board[x][y] = val;
    }
}

void dfs(int idx){
    if(idx == v.size()){
        result = min(result, blindSpot());
        return ;
    }
    int x = v[idx].first;
    int y = v[idx].second;
    queue<pair<int, int>> q[4];
    
    for(int i = 0; i < 4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        
        while(0 <= nx && nx < n &&
        0 <= ny && ny < m &&
        board[nx][ny] != 6){
            if(board[nx][ny] == 0)
                q[i].push({nx, ny});
            nx += dx[i];
            ny += dy[i];
        }
    } // 4방향으로 볼 수 있는 모든 좌표 q에 저장
    
    if(board[x][y] == 1){
        for(int i = 0; i < 4; i++){
            changeBoard(q[i], -1);
            dfs(idx + 1);
            changeBoard(q[i], 0);
        }
    }
    else if(board[x][y] == 2){ // 수평, 수직 2방향
        for(int i = 0; i < 3; i += 2){
            changeBoard(q[i], -1);
            changeBoard(q[i + 1], -1);
            dfs(idx + 1);
            changeBoard(q[i], 0);
            changeBoard(q[i + 1], 0);
        }
    }
    else if(board[x][y] == 3){ // 4가지
        for(int i = 0; i < 2; i++){
            changeBoard(q[i], -1);
            for(int j = 2; j < 4; j++){
                changeBoard(q[j], -1);
                dfs(idx + 1);
                changeBoard(q[j], 0);
            }
            changeBoard(q[i], 0);
        }
    }
    else if(board[x][y] == 4){ // 3방향
        for(int i = 0; i < 4; i++){
            changeBoard(q[i], -1);
            changeBoard(q[(i + 1) % 4], -1);
            changeBoard(q[(i + 2) % 4], -1);
            dfs(idx + 1);
            changeBoard(q[i], 0);
            changeBoard(q[(i + 1) % 4], 0);
            changeBoard(q[(i + 2) % 4], 0);
        }
    }
    else{
        for(int i = 0; i < 4; i++)
            changeBoard(q[i], -1);
        dfs(idx + 1);
        for(int i = 0; i < 4; i++)
            changeBoard(q[i], 0);
    }
}

int main(){
    int cnt = 0;
    cin >> n >> m;
    for(int i = 0; i < n; i++)
        for(int j = 0; j < m; j++){
            cin >> board[i][j];
            if(1 <= board[i][j] && board[i][j] <= 5)
                v.push_back({i, j});
        }
    
    dfs(0);
    cout << result;
}