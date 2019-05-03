#include<cstdio>
#include<iostream>


typedef struct {
	int data[10][10] = { 0 };
}table;

int lcs(char* x, char*y, int i, int j, table* t) {
	int m = 0, n = 0;
	for (m = 0; m <= i; m++)
		t->data[m][0] = 0;
	for (n = 0; n <= j; n++)
		t->data[0][n] = 0;
	for (m = 1; m <= i; m++) {
		for (n = 1; n <= j; n++) {
			if (x[m - 1] == y[n - 1])
				t->data[m][n] = t->data[m - 1][n - 1] + 1;
			else if (t->data[m][n - 1] >= t->data[m - 1][n])
				t->data[m][n] = t->data[m][n - 1];
			else
				t->data[m][n] = t->data[m - 1][n];
		}
	}
	return t->data[i][j];
}
void main() {
	char arr1[] = "ood";
	char arr2[] = "good";
	table t;
	
	printf("%d \n", lcs(arr1, arr2, 3, 4, &t));
	for (int i = 0; i <= 3; i++) {
		for (int j = 0; j <= 4; j++) {
			printf(" %d ", t.data[i][j]);
		}
		printf("\n");
	}


}