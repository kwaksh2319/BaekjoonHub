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
	int i, j, t, cnt, power;
	char c;
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
	long long s;
	long long t;

};
struct GDatas {
	int change;
	int index;
	
	string times;

};
bool cmp(const Data &a,const Data &b) {
	if (a.s == b.s) {
		return a.t < b.t;
	}
	
	return a.s < b.s;
}
int diri[] = { 1,-1,0,0, 1,1,-1,-1 };
int dirj[] = { 0,0,1,-1, 1,-1,-1,1 };
int n, m;
vector<vector<bool>>gVisited;
vector<vector<int>>maps;
vector<vector<vector<int>>>gmaps;
vector<bool>gbchick;
vector<Point>pStart;
vector<Point>pCitys;
int gmins = 0;
map<int, vector<int>>saveData;
int gCnts = 0;

vector<long long >gSUM;
long long gMax = 0;

void dfs(int index,int cnt,vector<int>saves,int ms) {
	//gbchick[index] = true;
	if (cnt>= m) {
		long long  sum = 0;
		//for (int j = 0; j < saves.size(); j++) {
		//	cout << saves[j] << ",";
		//}
		//cout << endl;
		for (int i = 0; i < pCitys.size(); i++) {
			long long min = 0;
			//cout << pCitys[i].i << "," << pCitys[i].j << endl;
			for (int j = 0; j < saves.size(); j++) {
				//치킨 a ,b 
				//cout << pStart[saves[j]].i <<","<< pStart[saves[j]].j << endl;
				//cout << abs(pStart[saves[j]].i - pCitys[i].i) + abs(pStart[saves[j]].j - pCitys[i].j);
				//cout << endl;
				//cout << endl;
				if (min == 0) {
					min = abs(pStart[saves[j]].i - pCitys[i].i) + abs(pStart[saves[j]].j - pCitys[i].j);
				}
				else if (min!=0 ) {
					if (min >= abs(pStart[saves[j]].i - pCitys[i].i) + abs(pStart[saves[j]].j - pCitys[i].j) ) {
						min = abs(pStart[saves[j]].i - pCitys[i].i) + abs(pStart[saves[j]].j - pCitys[i].j);
					}
					
				}
				
			}
			sum += min;
			//cout << min<<endl;
			
		}
		if (gMax == 0) {
			gMax = sum;
		}
		else if (gMax>sum) {
			gMax = sum;
		}
		//cout << sum << endl;
		//cout << endl;

		saves.clear();
		return ;
	}
	gbchick[index] = true;
	for (int i = index; i < pStart.size(); i++) {
		
		if (gbchick[i] == false) {
			saves.push_back(i);
			vector<int>tmp = saves;
			dfs(i,cnt+1, tmp,ms);
			saves.pop_back();
			gbchick[i] = false;
		}
		
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n >> m;

	vector<bool>tmpVisited(n,false);
	vector<vector<bool>>bVisited(n,tmpVisited);
	vector<vector<bool>>initbVisited(n, tmpVisited);
	//맵설정
	for (int i = 0; i < n; i++) {
		vector<int>tmpmaps;
		for (int j = 0; j < n; j++) {
			int tmp;
			cin >> tmp;
			if (tmp == 2) {
				Point initStart;
				initStart.i = i + 1;
				initStart.j = j + 1;
				initStart.cnt = 0;
				pStart.push_back(initStart);//치킨집//a,b,c,d,e

			}
			if (tmp == 1) {
				Point initStart;
				initStart.i = i + 1;
				initStart.j = j + 1;
				initStart.cnt = 0;
				pCitys.push_back(initStart);//도시//a,b,c,d,e

			}
			tmpmaps.push_back(tmp);
		}
		maps.push_back(tmpmaps);
	}

	

	
	//for (int j = 1; j <= m; j++) {
		vector<bool>bchick(pStart.size(), false);
		gbchick = bchick;
		vector<int>saves;
		for (int i = 0; i < pStart.size(); i++) {
			//pStart
			if (gbchick[i] == false) {
				//0 1 2
				saves.push_back(i);
				vector<int>tmp = saves;
				dfs(i, 1, tmp,0);
				saves.pop_back();
			}
		}
	//}
		cout << gMax;
	
	
	return 0;
}