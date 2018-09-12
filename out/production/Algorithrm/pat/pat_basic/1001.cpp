#include <iostream> 
using namespace std;

int main(){
	int n, result;
	result = 0;
	cin >> n;
	while(n != 1){
		if(n % 2 == 0){
			n = n/2;
			result++; 
		}
		else {
			n = 3*n + 1;
			n = n/2;
			result++;
		}
	}
	cout << result;
	return 0;
}
