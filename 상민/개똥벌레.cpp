#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main() {
    int n, h;
    cin >> n >> h;

    vector<int> topdown(h + 1, 0); // 종유석
    vector<int> bottomup(h + 1, 0); // 석순
    vector<int> hits(h + 1, 0);        // 합 벡터

    // 종유석과 석순 높이 입력
    for (int i = 0; i < n / 2; ++i) {
        int a, b;
        cin >> a >> b;
        bottomup[a]++;
        topdown[h + 1 - b]++;
    }
    //확인  
    for(int i = 0 ; i <= h; i++){
        cout << i <<"짜리 석순" << bottomup[i] << "\n";
    }
    for(int i = 0 ; i <= h; i++){
        cout << i << "이상높이 종유석 : " << topdown[i] << "\n";
    }

    // 종유석 누적합 계산 (아래에서 위로)
    for (int i = 1; i <= h; ++i) {
        topdown[i] += topdown[i - 1];
    }
    //확
    for(int i = 0 ; i <= h; i++){
        cout << i << "이상높이 종유석 : " << topdown[i] << "\n";    
    }

    // 석순 누적합 계산 (위에서 아래로)
    for (int i = h - 1; i >= 1; --i) {
        bottomup[i] += bottomup[i + 1];
    }

    //확인 
    for(int i = 0 ; i <= h; i++){
        cout << i <<"짜리 석순" << bottomup[i] << "\n";
    }


    // 높이에 따른 부딪힘 계산
    for (int i = 1; i <= h; ++i) {
        hits[i] = topdown[i] + bottomup[i];
    }

    for(int i = 0 ; i <= h; i++){
        cout << i << "칸에 있는 : " << hits[i] << "\n";    
    }

    // 최솟값 찾기
    int minHits = *min_element(hits.begin() + 1, hits.end());
    int minCount = count(hits.begin() + 1, hits.end(), minHits);

    // 결과 출력
    cout << minHits << " " << minCount << "\n";

    return 0;
}
