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


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	//폴리오미노 크기가 1x1 정사각형을 여러개 붙인 도형
	//정사각형이 서로 겹치면 안된다.
	//도형은 모두 연결되어야한다
	//정사각형의 변끼리 연결되어 있어야한다. 즉 꼭짓점과 꼭짓점만 맞닿아 있으면 안된다
	//정사각형 4개를 이어붙인 테트로모니 5가지 갓이다
	//nxm인 종이 위에 테트로미노 하나를 놓으려고 한다.
	
	int n, m;
	cin >> n >> m;
	vector<vector<int>>maps;
	for (int i = 0; i < n; i++) {
		vector<int>tmpMaps;
		for (int j = 0; j < m; j++) {
			int tmp;
			cin >> tmp;
			tmpMaps.push_back(tmp);
		}
		maps.push_back(tmpMaps);
	}
	

	int sum = 0;
	for (int k = 0; k < 5 ; k++) {
		
		for (int z = 0; z < maps.size(); z++) {
			//2x2
			for (int t = 0; t < maps[z].size(); t++) {
				//square
				int width = 0;//2;
				int height = 0;//2;
				int squre = 0;
				if (k == 0) {
					width = 2;
					height = 2;
				}
				else if (k == 1) {
					 width = 1;//2;
					 height = 4;//2;
				}
				else if (k == 2) {
					width = 4;//2;
					height = 1;//2;
				}
				else if (k == 3) {
					width =2;//2;
					height = 3;//2;
				}
				else if (k == 4) {
					width = 3;//2;
					height = 2;//2;
				}
				

				int squreheight = height + z;
				int squrewidth = width + t;
				if (squreheight > maps.size() || squrewidth > maps[z].size()) {
					continue;
				}
				int tmpsum = 0;
				vector<int> tmpsumarray;
				
					for (int i = z; i < squreheight; i++) {
						for (int j = t; j < squrewidth; j++) {
							tmpsum += maps[i][j];
						}

					}
					if (k == 0 || k == 1 || k == 2) {
						sum = max(tmpsum, sum);
					}
					else if (k == 3) {
						tmpsumarray.push_back(tmpsum - maps[z][squrewidth - 1] - maps[squreheight - 1][t]);
					
						tmpsumarray.push_back(tmpsum - maps[z][t] - maps[squreheight - 1][squrewidth - 1]);

						tmpsumarray.push_back(tmpsum - maps[z][t] - maps[squreheight - 1][t]);
						
						tmpsumarray.push_back(tmpsum - maps[z][squrewidth - 1] - maps[squreheight - 1][squrewidth - 1]);

						tmpsumarray.push_back(tmpsum-maps[z][t]-maps[z+1][t]);

						tmpsumarray.push_back(tmpsum - maps[squreheight - 1][squrewidth - 1] - maps[squreheight - 2][squrewidth - 1]);

						tmpsumarray.push_back(tmpsum - maps[squreheight - 1][t] - maps[squreheight - 2][t]);

						tmpsumarray.push_back(tmpsum - maps[z][squrewidth - 1] - maps[z+1][squrewidth - 1]);

						sort(tmpsumarray.begin(), tmpsumarray.end(),greater<>());
						sum = max(tmpsumarray[0], sum);
						tmpsumarray.clear();
					}
					else if (k==4) {
						tmpsumarray.push_back(tmpsum - maps[z][t] - maps[squreheight - 1][squrewidth - 1]);
				
						tmpsumarray.push_back(tmpsum - maps[squreheight - 1][t] - maps[z][squrewidth - 1]);

						tmpsumarray.push_back(tmpsum - maps[z][t] - maps[z][squrewidth - 1]);

						tmpsumarray.push_back(tmpsum - maps[squreheight - 1][t] - maps[squreheight - 1][squrewidth - 1]);

						tmpsumarray.push_back(tmpsum - maps[z][t] - maps[z][t+1]);

						tmpsumarray.push_back(tmpsum - maps[z][t+1] - maps[z][squrewidth - 1]);

						tmpsumarray.push_back(tmpsum - maps[squreheight - 1][squrewidth - 2] - maps[squreheight - 1][squrewidth - 1]);

						tmpsumarray.push_back(tmpsum - maps[squreheight - 1][t] - maps[squreheight - 1][t+1]);

						sort(tmpsumarray.begin(), tmpsumarray.end(),greater<>());
						sum = max(tmpsumarray[0], sum);
						tmpsumarray.clear();
					}
			}
		}
	
	}
	cout << sum;
	return 0;
}