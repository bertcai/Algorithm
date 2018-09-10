#include <iostream>
using namespace std;

class School{
	public:
		int no;
		int grade;
};

int main(){
	int n;
	cin >> n;
	int max,total[100000] = {0};
	max = 0;
	int m_no = 0;
	School sch[n];
	for(int i=0; i<n;i++){
		cin >> sch[i].no >> sch[i].grade;
		total[sch[i].no] += sch[i].grade;	
	}
	for(int i=0;i<100000;i++){
		if(max < total[i]){
			max = total[i];
			m_no = i;
		}
	}
	cout << m_no << ' ' << max;
	return 0;
}
