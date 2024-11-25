#include <iostream>
#include <vector>
#include <queue>
#include<string>
#include<algorithm>
using namespace std;

struct Point {
	int i, j,cnt;
};

void Prints(vector<vector<int>>maps, int n, int m) {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cout << maps[i][j];
		}
		cout << endl;
	}
	cout << endl;
}

void Prints(vector<vector<bool>>maps, int n, int m) {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cout << maps[i][j];
		}
		cout << endl;
	}
	cout << endl;
}

int main() {
	int n,m,k;

	cin >> n >> m >> k;
	vector<bool>tmpVisited(m,false);
	vector<vector<bool>>bVisited(n,tmpVisited);
	vector<int>tmpMaps(m, 0);
	vector<vector<int>>maps(n, tmpMaps);
	for (int z = 0; z < k; z++) {
		int i,j;
		cin >> i >> j;
		maps[i - 1][j - 1] = 1;
		bVisited[i - 1][j - 1] = true;


	}
	//Prints(maps, n, m);
	int max = 0;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++) {
			int cnt = 0;
			if (maps[i][j] == 1 && bVisited[i][j] == true) {
				Point p;
				p.i = i;
				p.j = j;
				p.cnt = 1;
				cnt++;
				
				if (max < cnt) {
					
					max = cnt;
				}
				bVisited[i][j] = false;
				queue<Point>q;
				q.push(p);
				int diri[] = { 1,-1,0,0 };
				int dirj[] = { 0,0,1,-1 };
				//Prints(bVisited, n, m);
				while (!q.empty()) {
					Point start = q.front();
					q.pop();
					for (int v = 0; v < 4; v++) {
						int tmpDiri = start.i + diri[v];
						int tmpDirj = start.j + dirj[v];
						if (tmpDiri==-1|| tmpDirj==-1|| tmpDiri>=n|| tmpDirj>=m||bVisited[tmpDiri][tmpDirj]==false) {
							continue;
						}
						if (maps[tmpDiri][tmpDirj] == 1) {
							Point tmpp;
							tmpp.i = tmpDiri;
							tmpp.j = tmpDirj;
							tmpp.cnt = start.cnt + 1;
							cnt++;
						//	cout << cnt <<endl;
							if (max < cnt) {
								max = cnt;
							}
							bVisited[tmpDiri][tmpDirj] = false;
							q.push(tmpp);
							//Prints(bVisited, n, m);
						}
					}
				}
			}
		}
	}
	cout << max;
	
	return 0;
}