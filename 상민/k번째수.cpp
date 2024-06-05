#include<iostream>
using namespace std;
int main(){
    int n, k;
    int mod_index, div_index; // 열, 행

    cin >> n >> k;
    k +=1;
    mod_index = k % n; //1
    div_index = (k / n)+1; //3
    cout << mod_index * div_index;

}