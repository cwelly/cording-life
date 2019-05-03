#include<iostream>
using namespace std;
int calc(int n, int arr[100]);
int main() {
	int test_case, n, result[100];
	result[1] = 1;
	result[2] = 2;
	result[0] = 0;
	result[3] = 4;
	cin >> test_case;
	for (int i = 1; i <= test_case; i++) {
		cin >> n;
		cout << calc(n, result);
	}


	return 0;
}
int calc(int n, int arr[100]) {
	for (int i = 4; i <= n; i++) {
		arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
	}
	return arr[n];
}