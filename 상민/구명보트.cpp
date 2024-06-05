#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    sort(people.rbegin(),people.rend());

    int start=0,end=people.size()-1;
//    [80, 70, 50, 50]
    while(start<end){
        if(people[start]+people[end]<=limit)
        {
            end--;
        }
        answer++;
        start++;
    }
    if(start==end)
        answer++; 
    return answer;
}

int main(){
    vector<int> people{70, 50, 80, 50};
    cout << solution(people, 100);
}