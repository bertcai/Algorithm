#include <cstdio>
#include <iostream>
using namespace std;

const int n = 54;

char card[5] = { 'S','H','C','D','J' };



int main() {
	int start[n + 1];
	int next[n + 1];
	int end[n + 1];
	for (int i = 1; i <= n; i++) {
		start[i] = i;
	}
	int k;
	scanf_s("%d", &k);
	int flag = 0;
	for (int i = 1; i <= n; i++) {
		scanf_s("%d", &next[i]);
	}
	for (int step = 1; step <= k; step++) {
		for (int i = 1; i <= n; i++) {
			end[next[i]] = start[i];
		}
		for (int i = 1; i <= n; i++) {
			start[i] = end[i];
		}
	}
	for (int i = 1; i <= n; i++) {
		if (!flag) {
			flag = 1;
		}
		else {
			printf(" ");
		}
		start[i]--;
		int num = start[i] % 13 + 1;
		//printf("%c", card[3]);
		printf("%c%d", card[start[i] / 13], num);
	}
	//system("pause");
	return 0;
}