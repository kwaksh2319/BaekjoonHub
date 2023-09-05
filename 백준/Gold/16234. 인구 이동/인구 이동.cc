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
	int sum = 0; 
	int cnt=0;
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


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	//A[r][c]
	int n, L, R;
	cin >> n >> L >> R;
	vector<vector<int>>A;
	vector<vector<int>>copyA;
	vector<bool>tmpbVisisted(n, false);
	vector<vector<bool>>bVisisted(n, tmpbVisisted);
	vector<vector<bool>>initbVisisted(n, tmpbVisisted);
	for (int i = 0; i < n; i++) {
		vector<int>tmpA;
		for (int j = 0; j < n; j++) {
			int tmp;
			cin >> tmp;
			tmpA.push_back(tmp);
		}
		A.push_back(tmpA);
	}
	copyA = A;
	//연합인구수/연합을 이루는칸의갯수
	//편의상 소수점은 버린다
	//연합해쳬 국경선 닫ㄷ는다
	int diri[] = { 1, -1, 0, 0 };
	int dirj[] = { 0, 0, 1, -1 };

	
	int gCnt = 0;
	bool bCheckt = false;
	
	//다시 반복 
	while(true){
		int sum = 0;
		int cnt = 0;
		vector<Point>rem;
		for (int z = 0; z < n; z++) {
			for (int t = 0; t < n; t++) {
				//시작지점을 먼저 queue찾기
				bool bOpen = false;
				//bVisisted = initbVisisted;
				
				if (bVisisted[z][t] == false) {

					Point p;
					p.i = z;
					p.j = t;
					queue<Point> q;
					rem.push_back(p);
					sum += A[p.i][p.j];
					q.push(p);

					while (!q.empty()) {
						Point start = q.front();
						bVisisted[start.i][start.j] = true;
						q.pop();
						
						for (int i = 0; i < 4; i++) {
							int tmpi = start.i + diri[i];
							int tmpj = start.j + dirj[i];
							if (tmpi == -1 || tmpj == -1 || tmpi >= n || tmpj >= n) {
								continue;
							}

							if (bVisisted[tmpi][tmpj] == true) {
								continue;
							}

							int anw = abs(A[start.i][start.j] - A[tmpi][tmpj]);
							if (anw >= L && anw <= R) {
								bOpen = true;
								
								bCheckt = true;
								Point tmpP;
								tmpP.i = tmpi;
								tmpP.j = tmpj;
								sum += A[tmpP.i][tmpP.j];
								bVisisted[tmpi][tmpj] = true;
								rem.push_back(tmpP);
								q.push(tmpP);
							}

						}


					}
					
					if (rem.size() > 1) {
						cnt = rem.size();
						int end = sum / cnt;
						for (int u = 0; u < rem.size(); u++) {
							copyA[rem[u].i][rem[u].j] = end;
						}
						
					}
					
					rem.clear();
					sum = 0;
					

				}
			}
		}
		A = copyA;
		sum = 0;
		bVisisted = initbVisisted;
		
		if (bCheckt == false) {
			break;
		}
		else {
			gCnt++;
		}
		bCheckt = false;
	}
	
	cout << gCnt;

	return 0;

}