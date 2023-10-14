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
vector<vector<int>>glists;
vector<char>gcolors;
vector<bool>gbVisisted;
int gn, gm;
bool gCheck = false;
//R,G
void dfs(int k, char co) {
	//cout << k << ":" << co << endl;
	gbVisisted[k] = true;
	gcolors[k] = co;
	for (int i = 0; i < glists[k].size(); i++) {
		if (gcolors[ glists[k][i] ] == co) {
			//cout << "impossible"<<endl;
			//cout << k << ":" << co << endl;
			gCheck = true;
			return ;
		}
		else {
			if (gbVisisted[ glists[k][i] ] == false) {
				if (co == 'R') {
					dfs( glists[k][i], 'G');
				}
				else if (co == 'G') {
					dfs( glists[k][i], 'R');
				}
			}
		}
	}
	
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int T;
	cin >> T;
	vector<string>anw;
	for (int z = 0; z < T; z++) {
		int n, m;
		cin >> n >> m;
		gn = n;
		gm = m;
		gCheck = false;
		vector<char>colors(n + 1);
		vector<bool>bVisisted(n + 1, false);
		gcolors = colors;
		vector<vector<int>>lists(n+1);
		for (int i = 0; i < m; i++) {
			int tmpi;
			int tmpj;
			cin >> tmpi;
			cin >> tmpj;
			lists[tmpi].push_back(tmpj);
			lists[tmpj].push_back(tmpi);
		}
		glists = lists;
		gbVisisted = bVisisted;
		for (int i = 1; i < lists.size(); i++) {
			if (gbVisisted[ i ] == false) {
				dfs(i, 'R');
			}
			
		}
		if (gCheck == true) {
			
			anw.push_back("impossible");
		}
		else {
			
			anw.push_back("possible");
		}
	
	}
	for (int i = 0; i < anw.size(); i++) {
		cout << anw[i] << endl;
	}

	return 0;
}