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

struct Data {
	int index;
	char color = 'G';

};
struct GDatas {
	int change;
	int index;

	string times;

};
vector<vector<int>>gmaps;
vector<bool>gBvisited;
vector<int>save;
int n, m;
bool bCheck = false;
void dfs(int k,int cnt) {
	//cout << k << "," << cnt << endl;
	if (cnt == 4) {
		bCheck = true;
		//cout << cnt;
		return;
	}/**/
	
	
	
	for (int i = 0; i < gmaps[k].size(); i++) {
		//cout << gmaps[k][i] << ",";
		if (gBvisited[ gmaps[k][i] ] == false) {
			gBvisited[ gmaps[k][i] ] = true;
			save.push_back(i);
			
			dfs(gmaps[k][i],cnt+1);
			save.pop_back();
			
			gBvisited[gmaps[k][i]] = false;
		}
	}
	
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	//a->b 친구
	//b->c 친구
	//c->d 친구
	//d->e 친구
	
	cin >> n >> m;
	vector<vector<int>>maps(n);
	vector<bool>visited(n, false);
	gBvisited = visited;
	for (int i = 0; i < m; i++) {
		int s, e;
		cin >> s >> e;
		maps[s].push_back(e);
		maps[e].push_back(s);
	}
	gmaps = maps;
	//Prints(maps, n, m);
	for (int i = 0; i < n; i++) {
		gBvisited[i] = true;
		dfs(i, 0);
		gBvisited[i] =false;

		if (bCheck == true) {
			cout << 1;
			i = n + 1;
		}

	}
	if (bCheck == false) {
		cout << 0;
	}
	
	//gBvisited[gmaps[k][i]] = true;
	
}