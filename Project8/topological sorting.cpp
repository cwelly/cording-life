//위상정렬 by indegree way
#include<cstdio>
#include<iostream>
#include<vector>
#include<queue>
using namespace std;
vector<int> arr[100];
queue<int> answer;
vector<int> inde(100, 0);
void topp(queue<int>& answer, vector<int>& inde, int size);
void main() {


	int n = 9, size = 9;
	arr[1].push_back(2);
	arr[2].push_back(9);
	arr[4].push_back(6);
	arr[5].push_back(1);
	arr[5].push_back(7);
	arr[5].push_back(8);
	arr[7].push_back(3);
	arr[8].push_back(4);
	arr[9].push_back(4);


	inde[1] = 1;
	inde[2] = 1;
	inde[3] = 1;
	inde[4] = 2;
	inde[6] = 1;
	inde[7] = 1;
	inde[8] = 1;
	inde[9] = 1;
	//while (n--) {
	//	int u, v;
	//	cin >> u >> v;
	//	arr[u].push_back(v);        //adj에 인접리스트 담기
	//	inde[v]++;              //indegree 업데이트
	//}
	topp(answer, inde, size);
	cout << "ANSWER : ";
	while (!answer.empty()) {
		cout << answer.front() << " ";
		answer.pop();
	}
	cout << '\n';

}
void topp(queue<int>& answer, vector<int> &inde, int size) {
	int inde_count = 0, tmp, inde_vertex_size, s;
	queue<int> count;
	while (inde_count != size) {// 만약 모든 버텍스를 answer에 push할때까지 반복한다.
		inde_count = 0;

		for (int i = 1; i < size + 1; i++) {// 인디그리가 0인값을 count 큐에 넣는다

			if (inde[i] == -1) { inde_count++; }
			else if (inde[i] == 0) { count.push(i); }
		}
		while (!count.empty()) {// 이제 0인 버텍스를 차례로 answer큐에 넣고, 관련된 버텍스를 찾아가 인디그리 값 하나씩줄인뒤 count에서 팝
			answer.push(count.front());//count 의 앞에있는값( 인디그리가 0인 버텍스)를 answer에 버텍스 추가
			//관련된 버텍스를 찾아가 인디그리 하나씩줄인다
			inde_vertex_size = arr[count.front()].size();
			while (inde_vertex_size != 0) {//해당 버텍스 벡터안에 있는 수만큼 반복
				inde[arr[count.front()].at(inde_vertex_size - 1)]--;
				inde_vertex_size--;
			}
			inde[count.front()] = -1;//해당 버텍스의 인디그리값을 -1로 설정
			count.pop();// 인디그리가 0인값을 줄여나간다.
		}

	}

}