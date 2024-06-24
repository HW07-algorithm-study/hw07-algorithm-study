#include<iostream>
using namespace std;

int main(){
	for(int t = 1; t <= 10; t++){
		int N;
		cin >> N;
		int arr[100][100];
		//판 입력 
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				cin >> arr[i][j];
			}
		}

		int cnt = 0;

		//1은 N, 2는 S
		// 세로줄 주루룩 검사
		for(int j = 0; j < N; j++){ 
			int flag = 0;
			for(int i = 0; i < N; i++){
				if(arr[i][j] == 1){
					flag = 1;
				}else if(arr[i][j] == 2 && flag == 1){
					cnt++;
					flag = 0;
				}
			}
		}
		cout << "#" << t << " " << cnt << endl;
	}
	return 0;
}