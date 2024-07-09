#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
    //The Trip, 2007 
    int n,v,tc=0;
    // c++ 형식으로
    cin >> n;
    while(n){
        if(tc++) cout << endl;
        vector<int> bags;
        for(int i=0;i<n;i++){
            cin >> v;
            bags.push_back(v);
        }
        sort(bags.begin(),bags.end()); 
        int maxDup = 1; // 최대 중복값
        int cur = 1; // 현재 중복값
        for(int i=1;i<bags.size();i++){
            if(bags[i] == bags[i-1]) // 중복값이면
                cur++;
            else 
                cur = 1;
            maxDup = max(cur,maxDup); // 최대 중복값 갱신
        }
        cout << maxDup << "\n";
        for(int i=0;i<maxDup;i++){
            cout << bags[i];
            for(int j=i+maxDup;j<n;j+=maxDup)
                cout << " " << bags[j];
            cout << "\n";
        }
        cin >> n;
    }
}