#include <iostream>

using namespace std;

int main(){
	int num[1000];
	int n;
	cin >> n;
	int a1 = 0, a2 = 0, a3 = 0, a5 = 0;
	int c1, c2, c3, c4, c5;
	c1 = c2 = c3 = c4 = c5 = 0; 
	float a4;
	int flag = 1;
	
	for(int i = 0; i < n; i++){
		cin >> num[i];
		int temp = num[i] % 5;
		switch (temp){
			case 0:
				if(num[i]%2 == 0){
					c1++;
					a1 += num[i];
				}
				continue;
			case 1:
				c2++;
				a2 = a2 + flag * num[i];
				flag = -flag;
//				cout << temp << " "<< num[i] << " "<< a2 << endl;
				continue; 
			case 2:
				c3++;
				a3++;
				continue; 
			case 3:
				a4 += num[i];
				c4++;
				continue;
			case 4:
				c5++;
				if(num[i] > a5){
					a5 = num[i];
				}
				continue;
		}	
	}
	
	
	if(c1==0){
		printf("N ");
	}else{
		printf("%d ",a1); 
	}
	if(c2==0){
		printf("N ");
	}else{
		printf("%d ",a2); 
	}
	if(c3==0){
		printf("N ");
	}else{
		printf("%d ",a3); 
	}
	if(c4==0){
		printf("N ");
	}else{
		a4 = a4/c4;
		printf("%0.1f ",a4); 
	}
	if(c5==0){
		printf("N");
	}else{
		printf("%d",a5); 
	}
	return 0;
}
