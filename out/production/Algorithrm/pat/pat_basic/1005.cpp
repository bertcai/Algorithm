#include <iostream>
#include <algorithm>
using namespace std;

bool compare(int a,int b)
{
  return a>b;
}

int main(){
	int n;
	cin >> n;
	int receive[n];
	int result[n];
	int temp, temp2, flag = 0, count = 0;
	for(int i = 0; i < n; i++){
		cin >> receive[i];
	}
	
//	for(int i = 0; i < n; i++){
//		cout << "receive: " << receive[i];
//	}

	for(int i = 0; i < n; i++){
		temp = receive[i];
		for(int j = 0; j < n; j++){
			temp2 = receive[j];
			flag = 0;
			while(temp2 != 1){
//				cout << 't' << temp2;
				if(temp2 % 2 == 0){
					temp2 = temp2/2;
				} else {
					temp2 = (3 * temp2 + 1)/2;
				}
				if(temp == temp2){
					flag = 1;
					break;
				}
			}
			if (flag == 1){
				break;
			}
		}
		if(flag == 0){
			result[count] = receive[i];
			count++;
		}
	}
	sort(result, result + count,compare);
	for(int i = 0; i < count -1; i++){
		cout << result[i] << ' ';
	}
	cout << result[count-1];
	return 0;
}
