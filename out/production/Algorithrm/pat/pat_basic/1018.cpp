#include <iostream>
using namespace std;

int change(char c){
	if(c == 'B'){
		return 0;
	}
	if(c == 'C'){
		return 1;
	}
	if(c == 'J'){
		return 2;
	}
}

int main(){
	char mp[3] = {'B', 'C', 'J'};
	int n;
	cin >> n;
	int times_A[3] = {0};
	int times_B[3] = {0};
	int hand_A[3] = {0}, hand_B[3]={0};
	char c1, c2;
	int k1, k2;
	for(int i = 0; i<n;i++){
		cin >> c1 >> c2;
		k1 = change(c1);
		k2 = change(c2);
		if((k1+1)%3 == k2){
			times_A[0]++;
			times_B[2]++;
			hand_A[k1]++;
		}else if(k1 == k2){
			times_A[1]++;
			times_B[1]++;
		} else {
			times_A[2]++;
			times_B[0]++;
			hand_B[k2]++;
		}
	}
	cout << times_A[0] << " " << times_A[1] << " " << times_A[2] << endl;
	cout << times_B[0] << " " << times_B[1] << " " << times_B[2] << endl;
	int id1 = 0, id2 = 0;
	for(int i = 0; i < 3; i++){
		if(hand_A[i] > hand_A[id1]) id1 = i;
		if(hand_B[i] > hand_B[id2]) id2 = i;
	}
	cout << mp[id1] << " " << mp[id2];	
}
