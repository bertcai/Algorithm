#include <iostream>
#include <string>
using namespace std;

class Stu{
	public:
		string name;
		string sno;
		int grade;		
};

int main(){
	int n;
	cin >> n;
	int i;
	Stu stu[n];
	int max = 0, min = 0;
	for(i = 0; i < n; i++){
		cin >> stu[i].name >> stu[i].sno >> stu[i].grade;
	}
	for(i = 0; i < n; i++){
		if(stu[i].grade > stu[max].grade){
			max = i;
		}
		if(stu[i].grade < stu[min].grade){
			min = i;
		}
	}
	cout << stu[max].name << ' '<< stu[max].sno << endl;
	cout << stu[min].name << ' ' << stu[min].sno << endl;
}
