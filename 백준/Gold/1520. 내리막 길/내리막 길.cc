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
	int size ; 
	int cnt=0;
	int eat = 0;
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
	Point p;
	int cnt;
	int sum;
};

bool cmp(const Point &a, const Point &b) {
     
	if (a.cnt == b.cnt) {
		if (a.i == b.i) {
			//왼쪽
			return a.j < b.j;
		}
		//위쪽
		return a.i < b.i;
	}
	//거리 짧은
	return a.cnt < b.cnt;
	
}
int n, m;
vector<vector<int>>maps;
vector<vector<bool>>gbVisited;
vector <vector<int>>dp;
int diri[] = { 1,-1,0,0 };
int dirj[] = { 0,0,1,-1 };
int gcnt = 0;
int backtraking(Point p) {
	//gbVisited[p.i][p.j] = true;
	if (p.i == n - 1 && p.j == m - 1) {
		//gcnt++;
		
		return 1;
	}
	
	//cout << p.i << "," << p.j <<","<<dp[p.i][p.j]<< endl;
	
	if (dp[p.i][p.j] !=-1) {
		//cout << dp[p.i][p.j];
		
		return dp[p.i][p.j];
	}
	dp[p.i][p.j] = 0;
	for (int i = 0; i < 4; i++) {
		int tmpDiri = diri[i] + p.i;
		int tmpDirj = dirj[i] + p.j;
		if (tmpDiri == -1 || tmpDirj == -1 || tmpDiri >= n || tmpDirj >= m) {
			continue;
		}
		if (gbVisited[tmpDiri][tmpDirj] == true) {
			
			
			continue;
		}
		

		if (maps[p.i][p.j] > maps[tmpDiri][tmpDirj]) {
			Point tmpP;
			tmpP.i = tmpDiri;
			tmpP.j = tmpDirj;
		    
			//int a = 0;
			
			
			dp[p.i][p.j]+= backtraking(tmpP);
		//	Prints(dp, n, m);
			//cout <<"==================="<<endl;
			
			//cout << cnts;
	        //dp[tmpP.i][tmpP.j]= backtraking(tmpP);
			//gbVisited[tmpDiri][tmpDirj] = false;
		
		}
		
	}
	
	return dp[p.i][p.j];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;

	vector<bool>tmpbVisted(m,false);
	vector<vector<bool>>bVisted(n, tmpbVisted);

	vector<int>tmpdp(m, -1);
	vector<vector<int>>tmpdpd(n, tmpdp);
	dp = tmpdpd;
	gbVisited = bVisted;
	for (int i = 0; i < n; i++) {
		vector<int>tmpMaps;
		for (int j = 0; j < m; j++) {
			int tmp;
			cin >> tmp;
			tmpMaps.push_back(tmp);

		}
		maps.push_back(tmpMaps);
	}
	
	Point p;
	p.i = 0;
	p.j = 0;
	//dp[p.i][p.j] = 1;
	int ans=backtraking(p);
	cout << ans;
}