#include <iostream>
#include <string>
using namespace std;


int main(){
	string r1,r2;
	int d1, d2;
	int t1, t2;
	t1 =t2 = 0;
	cin >> r1 >> d1 >> r2 >> d2;
	for(int i = 0; i<r1.size(); i++){
		if((r1[i]-'0') == d1){
 			t1 = t1 * 10 + d1;		
		}
	}
	for(int i = 0; i<r2.size(); i++){
		if((r2[i]-'0') == d2){
			t2 = t2*10 + d2;
		}
	}
	cout << t1 + t2;
	return 0;
}
