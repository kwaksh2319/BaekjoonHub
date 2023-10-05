#include <iostream>
#include <vector>
#include <queue>
#include<string>
#include<algorithm>
#include<cmath>
#include<unordered_map>
#include<map>
#include<stack>
using namespace std;

struct Point {
	int i, j;
	int cnt = 0;
	
};

void Prints(vector<vector<int>>maps, int n, int m) {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cout << maps[i][j] << " ";
		}
		cout << endl;
	}
	cout << endl;
}

void Prints(vector<vector<bool>>maps, int n, int m) {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cout << maps[i][j] << " ";
		}
		cout << endl;
	}
	cout << endl;
}
void Prints(vector<vector<char>>maps, int n, int m) {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cout << maps[i][j];
		}
		cout << endl;
	}
	cout << endl;
}
void Prints(vector<vector<vector<char>>>maps, int n, int m, int k) {
	for (int t = 0; t < k; t++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cout << maps[t][i][j];
			}
			cout << endl;
		}
		cout << endl;
	}
	cout << endl;
}

void Prints(vector<vector<vector<bool>>>maps, int n, int m, int k) {
	for (int t = 0; t < k; t++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cout << maps[t][i][j];
			}
			cout << endl;
		}
		cout << endl;
	}
	cout << endl;
}
void Prints(vector<int>line, int n) {
	for (int i = 0; i < n; i++) {
		cout << line[i] << ",";
	}
	cout << endl;
}
void Prints(string str, int n) {
	for (int i = 0; i < n; i++) {
		cout << str[i] << ",";
	}
	cout << endl;
}

bool checkmaps(vector<vector<int>>maps, vector<vector<int>>anw, int n, int m) {
	bool bCheck = false;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (maps[i][j] != anw[i][j]) {
				bCheck = true;
				i = n + 1;
				j = m + 1;
				continue;
			}
		}

	}
	return bCheck;

}
bool findstart(vector<vector<int>>maps, vector<vector<int>>anw, int n, int m, int) {
	bool bCheck = false;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (maps[i][j] != anw[i][j]) {
				bCheck = true;
				i = n + 1;
				j = m + 1;
				continue;
			}
		}

	}
	return bCheck;

}
bool checkmaps(vector<vector<bool>>maps, int n, int m) {
	//bool bCheck = false;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (maps[i][j] == false) {
				//bCheck = true;
				return true;
			}
		}
	}
	return false;
}
struct Data {
	int arrive;
	int weight;
};
int n;
vector<vector<Data>>glists;
vector<bool>gbCheck;
vector<int>endPointfinds;
vector<bool>endCheck;
void findendpoint(int k) {
	gbCheck[ k ] = true;
	//cout << k<<",";
	bool binit = false;
	for (int i = 0 ; i < glists[k].size(); i++) {
		
		if (gbCheck[ glists[k][i].arrive ]==false) {

		   findendpoint( glists[k][i].arrive  );
		   binit = true;
		}
	}
	if (binit == false) {
		endPointfinds.push_back(k);
		endCheck.push_back(false);
	}
	//return true;
}
int maxs = 0;
void weight(int start,int sum) {
	
	//cout << start << ",";
	gbCheck[start] = true;
	bool binit = false;
	for (int i = 0; i < glists[start].size(); i++) {

		if (gbCheck[glists[start][i].arrive] == false) {
			
			weight(glists[start][i].arrive, sum+ glists[start][i].weight);
			binit = true;
		}
	}
	if (binit == false) {
		
		maxs = max(sum, maxs);
		//cout << "sum:"<<sum<<endl;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	//트리 사이클 없는 무방향 그래프
	//트리에서 어떤 두노드를 선태갷도 둘사이에 경로 항상 하나만 존재하게된다
	cin >> n;
	vector<vector<Data>>lists(n + 1);
	vector<bool>bCheck(n+1,false);
	for (int i = 0; i < n-1; i++) {
		Data tmp;
		int start;
		int arrive;
		int weight;

		cin >> start;
		cin >> arrive;
		cin >> weight;
		
		tmp.arrive = arrive;
		tmp.weight = weight;
		lists[start].push_back(tmp);

		tmp.arrive = start;
		lists[arrive].push_back(tmp);
	}
	glists = lists;
	gbCheck =bCheck;

	//끝 노드 찾기
	findendpoint(1);

	gbCheck =bCheck  ;
	//조합
	for (int i = 0; i < endPointfinds.size(); i++) {
		gbCheck = bCheck;
		
		weight(endPointfinds[i] ,0);
		
		//cout << endl;
	}
	cout << maxs;
	return 0;
}