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

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m;
	//아기상어크기는 2 
	//아기상어는 상하좌우로 인접한 한칸씩이동
    //아기상어는 자신의 크기보다 큰 물고기가 잇는칸을 갈수 없고
	//나머지 칸은 모두 지나갈수 잇다
	//아기상ㅇ어는 자신의 크기보다 작은 물고기만 먹을수잇다
	//크가가 같은 물고기는 먹을수는 없지만 그 물고기 잇는칸은 지나갈수는 잇다

	//아기상어
	//더이상 먹을수 잇는 물고기가 공간에 없다면 아기 상어는 엄마 상어 요청
	//먹을수 잇는 물고기가 1마리면 그물고기를 먹는다
	//먹을수 잇는 물고기가 1마리보ㅓ다 많은 거리가 가까운 물고리를 먹으러간다
	//거리는 아기 상어가 잇는칸에서 물고기가 잇는 칸으로 이동할때 지나야하는 칸의 최솟값이다
	//거리가 가까운 물고기가 많다면 가장위에 잇는 물고기 그러한 물고기가 여러마리면 가장 왼쪽에 잇는 물고기를 먹는다
	//이동 1초 크기가 2인 물고기는 2마리 먹으면 크기3인된다
	
	
	cin >> n;
	vector<vector<int>>maps;
	vector<vector<int>>initmaps;
	vector<bool>tmpVisisted(n, false);
	vector<vector<bool>>bVisited(n,tmpVisisted);
	vector<vector<bool>>initbVisited(n, tmpVisisted);
	Point p;
	for (int i = 0; i < n; i++) {
		vector<int>tmpMap;
		for (int j = 0; j < n; j++) {
			int tmp;
			cin >> tmp;
			if (tmp == 9) {
				p.i = i;
				p.j = j;
				p.size = 2;
				bVisited[i][j] = true;
				//initbVisited[i][j] = true;
			}
			tmpMap.push_back(tmp);
		}
		maps.push_back(tmpMap);
	}
	initmaps = maps;
	initmaps[p.i][p.j] = 0;
	maps = initmaps;
	//Prints(maps, n, n);
	//1.bfs로 위치 측정해서 물고기 위치 찾기 가까운거리 물고기
	

	int diri[] = { 1,-1,0,0 };
	int dirj[] = { 0,0,1,-1 };
	
	int gcnt = 0;
	while (true) {
		queue<Point>q;
		q.push(p);
		vector<Point> moving;
		while (!q.empty()) {
			Point start = q.front();
			q.pop();
	
			for (int i = 0; i < 4; i++) {
				int tmpDiri = start.i + diri[i];
				int tmpDirj = start.j + dirj[i];
				if (tmpDiri == -1 || tmpDirj == -1 || tmpDiri >= n || tmpDirj >= n) {
					continue;
				}
			//cout  << maps[tmpDiri][tmpDirj];
				if (bVisited[tmpDiri][tmpDirj] == true) {
					continue;
				}
			
				if (maps[tmpDiri][tmpDirj]> start.size ) {
				//아기상어보다 크면 갈수 없음
					continue;
				}
			
				Point tmpP;
				tmpP.i = tmpDiri;
				tmpP.j = tmpDirj;
				tmpP.cnt = start.cnt + 1;
				tmpP.size = start.size;
				tmpP.eat = start.eat;
				bVisited[tmpDiri][tmpDirj] = true;
				q.push(tmpP);

				if (maps[tmpDiri][tmpDirj] > 0) {

					if (tmpP.size > maps[tmpDiri][tmpDirj]) {
						//이동후 먹을 밥 후보
						moving.push_back(tmpP);
					}
					//동일한 케이스는 지나만 갈수 잇음
				}	
			}
		}

		if (moving.size() == 0) {
			//먹을게 없어 엄마!!
			break;
		}

		//물고기 제일 가까운거리, 많은경우 제일위 그래도 많으면가장 왼쪽
		sort(moving.begin(),moving.end(), cmp);

	//for (int i = 0; i < moving.size(); i++) {
		//cout << moving[i].i << "," << moving[i].j << endl;
	//}
		
		p = moving[0];
		gcnt = p.cnt;
		//먹은갯수
		
		if (p.size == moving[0].eat + 1) {
			
			p.size = p.size + 1;
			//cout << p.size << endl;
			p.eat = 0;
		}
		else {
			p.eat = moving[0].eat + 1;
		}
		//cout << p.i << "," << p.j << "," << p.eat << endl;
		//고정값
		//initbVisited[p.i][p.j] = true;
		bVisited = initbVisited;
		bVisited[p.i][p.j] = true;
		initmaps[p.i][p.j] = 0;
		maps = initmaps;
	}
	cout << gcnt;
	
}