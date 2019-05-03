#include<iostream>
using namespace std;
int fibo(int n);
int calc(int result);
int fibo_memo[30] = { 0 };
int main() {
	int n, result=0;
	fibo_memo[1]
	cin >> n;
	result=fibo(5);
	cout << calc(n);
	return 0;
}
int fibo(int n) {
	
		for
		return fibo_memo[n];
}
int  calc(int n) {
	int result = 0;
	for (int i = 0; n < fibo_memo[i]; i++) {
		if (fibo_memo[i] % 2 == 0)
		{
			result += fibo_memo[i];
		}
	}
	return result;
}