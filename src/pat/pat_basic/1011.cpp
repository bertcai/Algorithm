#include <iostream>
using namespace std;


class rec{
	public:
		long long a;
		long long b;
		long long c;
};

int main(){
	int n;
	cin >> n;
	rec rec[n];
	

	for(int i=0;i<n;i++){
		cin >> rec[i].a >> rec[i].b >> rec[i].c;
	}
	for(int i=0;i<n;i++){
//		cout << rec[i].a << ' '<< rec[i].b << ' '<< rec[i].c << endl; 
		if((rec[i].a+rec[i].b) > rec[i].c){
			cout << "Case #" << i+1 << ": " << "true" << endl;
		} else {
			cout << "Case #" << i+1 << ": " << "false" << endl;
		}
	}
	
}
