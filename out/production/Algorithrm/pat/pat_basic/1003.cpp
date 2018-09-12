#include <iostream>
#include <string>
using namespace std;

int main(){
	string receive[10];
	int n;
	cin >> n;
	int fst, mid, last, len, i, j;
	int pnum, tnum, temp, flag = 1;
	fst = mid = last = 0;
	for(int i = 0; i < n; i++){
		cin >> receive[i];
	}
	for(i = 0; i < n; i++){
		len = receive[i].length();
		pnum = 0;
		tnum = 0;
		flag = 1;
//		cout << "len: " << len << endl;
		for(j = 0; j < len; j++){
			if(receive[i][j] == 'P'){
				fst = j;
				pnum++;
//				cout << j;
			}
			if(receive[i][j] != 'P' && receive[i][j] != 'A' && receive[i][j] != 'T'){
				flag = 0;
//				cout << "flag:" << flag;
			}
//			cout << receive[i][j];
		}
		for(j = fst; j < len; j++){
			if(receive[i][j] == 'T'){
				mid = j - fst - 1;
				tnum++;
			}
			if(receive[i][j] != 'P' && receive[i][j] != 'A' && receive[i][j] != 'T'){
				flag = 0;
			}
		}
		last = len - mid - fst - 1 - 1;
//		cout << fst << mid << last << endl;
		if (fst != 0){
			temp = last/fst;
		}
		if(fst == last && fst == 0 && pnum == 1 && tnum == 1 && mid != 0 && flag){
			cout << "YES" << endl;
		}
		else if(mid == temp && flag && pnum == 1 && tnum == 1){
			cout << "YES" << endl;
		} else {
			cout << "NO" << endl;
		}
	}
	return 0;
}

