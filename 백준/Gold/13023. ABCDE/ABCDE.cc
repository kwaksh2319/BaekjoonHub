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
	int pos;
	int sec;
};
vector < vector<int>>glists;
vector<bool>gbCheck;
bool bCircle = false;
void dfs(int k,int cnt) {
	//gbCheck[k] = true;
	//cout << k << ","<<cnt<<endl;
	

	if (cnt == 5) {
		bCircle = true;
		return;
	}
	
	for (int i = 0; i < glists[k].size(); i++) {
		if (gbCheck[glists[k][i]]== false) {
			
			gbCheck[glists[k][i]] = true;
			dfs(glists[k][i],cnt+1);
			gbCheck[glists[k][i]] = false;
		}
		
	}

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	//a와b 친구다
	//b와 c친구다
	//c와 d친구다
	//d는 e친구다
	int n,m;
	cin >> n >> m;
	vector < vector<int>>lists(n);
	vector<bool>bCheck(n,false);
	
	for (int i = 0; i < m; i++) {
		int a,b;
		cin >> a>>b;
		lists[a].push_back(b);
		lists[b].push_back(a);
	}
	glists = lists;
	//cout << endl;
	for (int i = 0; i < n; i++) {
		gbCheck = bCheck;
		gbCheck[i] = true;
		dfs(i, 1);
		//cout << endl;
		if (bCircle==true) {
			break;
		}
	}
	
	//cout << endl;
	

	if (bCircle == false) {
		cout << 0;
	}
	else {
		cout << 1;
	}
	return 0;
}