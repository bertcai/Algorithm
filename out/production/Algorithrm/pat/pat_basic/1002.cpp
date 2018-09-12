#include <iostream>
#include <string>
using namespace std;

int main(){
	string receive;
	string result = "";
	string arr[10] = {" ling", " yi", " er", " san", " si", " wu", " liu", " qi", " ba", " jiu"};
	cin >> receive;
	int sum = 0, temp = 0;
	for (int i = 0; i < receive.length(); i++){
		temp = receive[i] - '0';
		sum += temp; 
	}
//	cout << sum << endl;
	while(sum != 0){
		temp = sum%10;
//		cout << arr[temp] << endl;
		result.insert(0, arr[temp]);
		sum = sum/10;
	}
	result.erase(0, 1);
	cout << result;
}
