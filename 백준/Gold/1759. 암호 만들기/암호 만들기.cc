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
vector<char>lists;
vector<bool> bCheck;
vector<char>save;
vector<string>gsave;
int L, C;
char md[5] = { 'a', 'e', 'i', 'o', 'u' };

void backtracking(int k,int cnt) {
	//cout << lists[k] << ",";
	if (cnt == L) {
		int parent = 0;
		int child = 0;
	
		for (int i = 0; i < save.size(); i++) {
			bool bFind = false;
			for (int j = 0; j < 5; j++) {
				
				if (md[j] == save[i]) {
				//	cout << md[j] << "," << save[i];
					bFind = true;
					parent++;
					break;
				}
				
			}
			if (bFind == false) {
				child++;
			}
			//cout << save[i] << ",";
		}
		
		if (child >= 2 && parent >= 1) {
			string tmp;
			for (int i = 0; i < save.size(); i++) {
				//cout << save[i] << ",";
				 tmp +=save[i];
			}
			gsave.push_back(tmp);
		}
		//cout << endl;
		return;
	}

	for (int i = k; i < C; i++) {
		if (bCheck[i] == false) {
			bCheck[i] = true;
		
			save.push_back(lists[i]);
			backtracking(i, cnt + 1);
			save.pop_back();
			bCheck[i] = false;
		}
		
	}
	//cout << endl;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	//조교가 방 열쇠를 주머니에 넣은 채깜빡하고 서울로 가버리는 황당한 상황에 
	//직면한 조교들은 702호 에 새로운 보안 시스템 설치
	//암호 서로다른 L개 한개의 모음 A,E,I,O,U과 최소 두개의 자음으로 구성
	//
	
	cin >> L >> C;
	for (int i = 0; i < C; i++) {
		char c;
		cin >> c;
		lists.push_back(c);
		bCheck.push_back(false);
	}
	sort(lists.begin(), lists.end());
	backtracking(0, 0);
	for (int i = 0; i < gsave.size(); i++) {
		cout << gsave[i] << endl;
	}
	return 0;
}