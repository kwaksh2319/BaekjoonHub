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
int n, m;
vector<bool>bTrack;
vector<Point>datas;
vector<vector<Point>>gsave;
vector<Point>save;
void backtracking(int k,int cnt ) {

	if (m <= cnt) {
		/*
		for (int i = 0; i < save.size(); i++) {
			cout << save[i].i<<","<<save[i].j<<endl;
		}
		cout << endl;*/
		gsave.push_back(save);
		//save.clear();
		return ;
	}

	for (int i = k; i < datas.size(); i++) {
		if (bTrack[i] == false) {
			bTrack[i] = true;
			save.push_back(datas[i]);
			backtracking(i, cnt + 1);
			save.pop_back();
			bTrack[i] = false;
		}
	}

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	//인체 치명적인 바이러스 
	//승원이가 침입햇고
	//바이러스 유출
	//연구소의 특정 위치에 바이러스 m개
	//승원이의 싢와 동시에 바이러스가 퍼짐

	//연구소는 nxn 
	//연구소 빈칸, 벽으로 이루어져잇으며, 벽은 칸 하나를 가득 차지한다.
	
	cin >> n >> m;
	vector<vector<int>>maps;
	vector<int>tmpCopymap(n,0);
	vector<vector<int>>tcopymaps(n, tmpCopymap);
	vector<vector<int>>copymaps(n, tmpCopymap);
	vector<bool>tmpVisited(n, false);
	vector<vector<bool>>bVisitied(n, tmpVisited);
	vector<vector<bool>>copyVisitied(n, tmpVisited);
	vector<vector<bool>>initbVisitied(n, tmpVisited);
	
	for (int i = 0; i < n; i++) {
		vector<int>tmpMaps;
		for (int j = 0; j < n; j++) {
			int tmp;
			cin >> tmp;
			tmpMaps.push_back(tmp);
			if (tmp == 1) {
				copymaps[i][j] = -1;
				tcopymaps[i][j] = -1;
				bVisitied[i][j] = true;
			}
			if (tmp == 2) {
				Point tmpP;
				tmpP.i = i;
				tmpP.j = j;
				datas.push_back(tmpP);
				//bVisitied[i][j] = true;
				//q.push(tmpP);
			}

		}
		maps.push_back(tmpMaps);
	}

	initbVisitied = bVisitied;

	for (int i = 0; i < datas.size(); i++) {
		bTrack.push_back(false);
	}

	backtracking(0,0);
	queue<Point>q;
	int diri[] = { 1,-1,0,0 };
	int dirj[] = { 0,0,1,-1 };
	//바이러스 둘수잇는경우의수 
	int maxs = -1;
	for (int z = 0; z < gsave.size(); z++) {
		
		for (int t = 0; t <m ; t++) {
			//cout << gsave[z][t].i << "," << gsave[z][t].j << endl;
			q.push(gsave[z][t]);
			bVisitied[gsave[z][t].i][gsave[z][t].j] = true;
		}
		//cout << endl;
		int tmpsd = 0;
		while (!q.empty()) {
			Point start = q.front();
			q.pop();
			for (int i = 0; i < 4; i++) {
				int tmpDiri = start.i + diri[i];
				int tmpDirj = start.j + dirj[i];
				if (tmpDiri == -1 || tmpDirj == -1 || tmpDiri >= n || tmpDirj >= n) {
					continue;
				}
				if (bVisitied[tmpDiri][tmpDirj] == true) {
					continue;
				}
				bVisitied[tmpDiri][tmpDirj] = true;
				Point tmpP;
				tmpP.i = tmpDiri;
				tmpP.j = tmpDirj;
				tmpP.cnt = start.cnt + 1;
				//copymaps[tmpP.i][tmpP.j]= start.cnt + 1;

				//cout << tmpP.cnt << ",";
				if (tmpsd < start.cnt + 1) {
					tmpsd = start.cnt + 1;
				}
			
				q.push(tmpP);
				//Prints(copymaps, n, n);

			}
		}

		bool check=checkmaps(bVisitied, n, n);
		//cout << tmpsd<<",";
		if (check==false) {
			if (maxs == -1) {
				maxs = tmpsd;
			}
			else {
				maxs = min(maxs, tmpsd);
			}
		}
		

		//copymaps = tcopymaps;
		bVisitied = initbVisitied;
		//cout << endl;
	}
	cout << maxs;
	/*

	
	
	*/
	
}