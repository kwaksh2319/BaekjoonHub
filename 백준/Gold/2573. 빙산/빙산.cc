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


vector<vector<int>>maps;
vector<vector<int>>copymaps;


int diri[] = { 1,-1,0,0 };
int dirj[] = { 0,0,1,-1 };
int n, m;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n >> m;

	queue<Point>q;
	queue<Point>checkq;

	vector<bool>tmpbVisited(m, false);
	vector<vector<bool>>bVisited(n, tmpbVisited);
	vector<vector<bool>>copybVisited;
	for (int i = 0; i < n; i++) {
		vector<int>tmpmap;
		for (int j = 0; j < m; j++) {
			int tmp;
			cin >> tmp;

			if (tmp != 0) {
				Point p;
				p.i = i;
				p.j = j;
				q.push(p);
				bVisited[p.i][p.j] = true;
			}
			

			tmpmap.push_back(tmp);
		}
		maps.push_back(tmpmap);
	}
	copybVisited = bVisited;
	copymaps = maps;
	bool bEnd = false;
	
	int year = 0;
	while (true) {
		
		if (bEnd == true) {
			break;
		}

		while (!q.empty()) {
			Point start = q.front();
			q.pop();
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int tmpDiri = start.i + diri[i];
				int tmpDirj = start.j + dirj[i];
				if (tmpDiri == -1 || tmpDirj == -1 || tmpDiri == n|| tmpDirj == m) {
					continue;
				}

				if (maps[tmpDiri][tmpDirj] != 0) {
					continue;
				}
				cnt++;
			}
			copymaps[start.i][start.j] -=cnt ;
			if (copymaps[start.i][start.j] <= 0) {
				copymaps[start.i][start.j] = 0;
				bVisited[start.i][start.j] = false;
			}
			
		}

		maps = copymaps;
		//cout << endl;
		//Prints(maps, n, m);
		copybVisited = bVisited;
		//cout << endl;
		//Prints(bVisited, n, m);
		bool bInit = false;
		bool bfind = false;
		int gcnt = 0;
		//섬 한개 인지 체크 후 q에 입력 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (maps[i][j]!=0&& bVisited[i][j]==true) {
					bfind = true;
					Point p;
					p.i = i;
					p.j = j;
					checkq.push(p);
					q.push(p);
				}
				while (!checkq.empty()) {
					Point start = checkq.front();
					checkq.pop();
					bVisited[start.i][start.j] = false;
					if (bInit == false) {
						gcnt++;
						
						if (gcnt > 1) {
							i = n;
							j = m;
							//cout << gcnt << ",";
							bEnd = true;
							break;
						}
						
						bInit = true;
					}

					for (int i = 0; i < 4; i++) {
						int tmpDiri = start.i + diri[i];
						int tmpDirj = start.j + dirj[i];
						if (tmpDiri == -1 || tmpDirj == -1 || tmpDiri == n || tmpDirj == m) {
							continue;
						}

						if (bVisited[tmpDiri][tmpDirj] == false) {
							continue;
						}

						if (maps[tmpDiri][tmpDirj] == 0) {
							continue;
						}
						
						bVisited[tmpDiri][tmpDirj] = false;
						Point tmpP;
						tmpP.i = tmpDiri;
						tmpP.j = tmpDirj;
						q.push(tmpP);
						checkq.push(tmpP);
					}
				}
				//cout << endl;
			//	Prints(bVisited, n, m);
				if (bInit == true) {
					bInit = false;
				}
				
			}
		}
		year++;
		bVisited = copybVisited;
		if (bfind == false) {
			year = 0;
			break;
			
		}
	}
	cout << year;
	
	return 0;
}