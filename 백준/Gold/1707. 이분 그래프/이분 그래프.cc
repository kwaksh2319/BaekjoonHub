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
	Point p;
	int cnt;
	int sum;
};
vector<vector<int>>glists;
vector<bool>gbChecks;
vector<int>colors;
int gv, ge;
bool bConfirm = false;
bool dfs( int k ,int cnt) {
	
	//cout << k <<":"<<cnt<< ",";
	gbChecks[k - 1] = true;
	colors[k - 1] = cnt;
	for (int i = 0; i < glists[k].size(); i++) {
		//cout << colors[glists[k][i] - 1] << ",";
		if (colors[glists[k][i] - 1]==0) {
		  if (dfs(glists[k][i], 3 - cnt) == false) {
				return false;
		  }
		}
		else if(colors[glists[k][i] - 1]==cnt){
		//	cout << "copy" << endl;
			return false;

		}

		
	}
	return true; 
	//cout << endl;
	//cout << "no" << endl;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	//그래프
	//정점 집합을 둘로 분열
	//각 집합에 속한 정점끼리는 인접하지 않도록 분할 할수 잇을때
	//그러한 그래프를 특별히 이분 그래프 라고 한다.
	int k;
	cin >> k;
	
	//각 정점은 1부터 v까지 차례로 번호가 붙어 잇다.
	//e개의 줄에 걸쳐 간선에 대한 정보가 주어지는데 
	vector<string>anw;
	for (int t = 0; t < k; t++)
	{
		bConfirm = false;
		//v 정점,e간선의 갯수
		int v, e;
		cin >> v >> e;
		gv = v;
		ge = e;
		//vector<int>tmplists(1,0);
		vector<vector<int>>lists(v+1);
		vector<bool>bChecks(v,false);
		gbChecks=bChecks;
		colors.clear();
		for (int i = 0; i < v; i++) {
			colors.push_back(0);
		}

		for (int i = 0; i < e; i++) {
			int x, y;
			cin >> x >> y;
			
			if (x > y) {
				int tmp = x;
				x = y;
				y = tmp;
			}

			lists[x].push_back(y);
			
			lists[y].push_back(x);
			//순환하면 이분 그래프
			//순환하지 않으면 이분그래프
			

		}
		glists = lists;
		for (int i = 1; i < v + 1; i++) {
			//if (gbChecks[i - 1] == false) {
				//cout << i << ",";
			//if (bConfirm == false) {
			if (colors[i-1] == 0) {
				bool bTEST = dfs(i, 1);
				if (bTEST == false) {
					bConfirm = true;
					break;
				}
			}
				
			//	gv--;
			//}
			   
			//}
			//cout << endl;
			
		}

		if (bConfirm == true) {
			anw.push_back("NO");
		}
		else {
			anw.push_back("YES");
		}
		
		//cout << endl;
	}
	for (int i = 0; i < anw.size(); i++)
	{
		cout << anw[i] << endl;
	}
}