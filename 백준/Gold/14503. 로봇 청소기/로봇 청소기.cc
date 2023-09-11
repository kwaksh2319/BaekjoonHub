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
	int r, c;
	int d ; 
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

vector<vector<int>>maps;
vector<vector<bool>>gbCheck;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	//현재 칸이 아직 저청소되지않는 경우 현재 칸 청소
	//현재 칸의 주변 4칸중 청소되지 않는 빈칸이 없는경우

	int n, m;
	cin >> n >> m;
	int r, c,d;
	cin >> r >> c >> d;
	
	vector<bool>btmpcheck(m, false);
	vector<vector<bool>>bCheck(n, btmpcheck);
	for (int i = 0; i < n; i++) {
		vector<int>tmpMaps;
		for (int j = 0; j < m; j++) {
			int tmp;
			cin >> tmp;
			tmpMaps.push_back(tmp);
			if (tmp == 1) {
				bCheck[i][j] = true;
			}
		}
		maps.push_back(tmpMaps);
	}
	gbCheck = bCheck;
	
	//방향체크 
//	1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
	
	Point start;
	start.r = r;
	start.c = c;
	start.d = d;
	int cnt = 0;
	int dirr[] = { -1,0,1,0 };
	int dirc[] = { 0,1,0,-1 };
	int gcnt = 0;
	while(true){
		
		//현재 칸 청소 확인
		if (bCheck[start.r][start.c]==false) {
			bCheck[start.r][start.c] = true;
			//maps[start.r][start.c] = 1;	
			gcnt++;
		}
	//	cout << endl;
	//	Prints(maps, n, m);
	//	cout << endl;
		//현재칸 주변 4칸중 청소가 되지안는 빈칸이 없는경우
		bool empty = false;
		for (int i = 0; i < 4; i++) {
			int tmpR = start.r + dirr[i];
			int tmpC = start.c + dirc[i];
			if (tmpR==-1|| tmpC==-1|| tmpR>=n||tmpC>=m) {
				//후진 불가
				//continue;
				
			}
			else {
				if (bCheck[tmpR][tmpC] == false) {
					empty = true;
				}
				
				
			}
			
		}

		if (empty == false) {
			//빈칸이 없는경우
			//후진 청소되지않음
			//0->2
			//1->3
			//2->0
			//3->1

			//후진
			int direct = (start.d + 2) % 4;

			int tmpR = start.r + dirr[direct];
			int tmpC = start.c + dirc[direct];
			
			if (tmpR == -1 || tmpC == -1 || tmpR >= n || tmpC >= m) {
			   //후진 불가 
			   //작동 중지
			   break;
			}
			else {
				if (maps[tmpR][tmpC]==1) {
					break;
				}
				start.r = tmpR;
				start.c = tmpC;
				start.d = start.d;
			}
		}
		else {
			//빈칸이 잇는경우

			//북4->서3 ->남2 ->동1
			int direct = ( (4+start.d  )- 1) % 4;
			
			int tmpR = start.r + dirr[direct];
			int tmpC = start.c + dirc[direct];
			//90도회전
			start.d = direct;
			if (tmpR == -1 || tmpC == -1 || tmpR >= n || tmpC >= m) {
				
				//continue;
			}
			else {
				if (bCheck[tmpR][tmpC] == false) {
					//그방향으로 전진
					start.r = tmpR;
					start.c = tmpC;
					
					
				}
			}

			

		}

		
		
	}
	cout << gcnt;
	
	

}