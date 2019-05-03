#include<iostream>
#include<algorithm>
using namespace std;

int main() {

	int n,income,result[1000000];
	for (int i = 0; i < 1000000; i++) {
		result[i] = 10000;
	}
	result[1] = 0;
	cin >> n;
	for (int i = 2; i <= n; i++) {
		if (i % 2 != 0) {//2로 안나뉘는 경우
			if (i % 3 != 0) {// 3으로도 안나뉘면
				result[i] = result[i - 1] + 1;
			}
			else
				result[i] = min(result[i / 3], result[i - 1]) + 1;//2로는 안나뉘고 3으론 나뉨
		}
		//2로나뉘는 경우
		else if (i % 3 != 0) {//2로나뉘지만, 3으론 안나뉨
			result[i] = min(result[i / 2], result[i - 1]) + 1;
		}
		else {
			result[i] = min(min(result[i / 2], result[i / 3]), result[i - 1]) + 1;
		}
	}
	cout << result[n];
	return 0;
}