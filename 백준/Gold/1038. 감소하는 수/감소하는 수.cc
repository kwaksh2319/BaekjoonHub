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

long long  gcnt=-1;
//0,1,2,3,4,5,6,7,8,9
vector<int>stacks;
vector<bool>bvisitied;
vector<int>save;
long long n;
 long long anw;
 string maxstrt;
void backtracking(unsigned long long k, unsigned long long cnt) {
	if (n >= 1023) {
		
		maxstrt= "-1";
		//cout << maxstrt;
		return ;
	}
	if (gcnt >= n) {
		
		return ;
	}
	if (save.size()==k) {
		gcnt++;
		maxstrt = "";
		for (int i = 0; i < save.size(); i++) {
			
			maxstrt += (save[i] + '0');
		}

		
		//cout << gcnt << endl;
		//anw =stol(maxstrt);
		//cout << maxstrt << ",";
		//cout << endl;
		
		return;
	}
	
	for(int i=0;i<10;i++) 
	{
		if (bvisitied[i] == false) {
			if (save.size() > 0) {
				//검사
				bool bCheck = false;
				for (int j = 0; j < save.size(); j++) {
					if ( save[j]< stacks[i]) {
						bCheck = true;
						break;
					}
				}

				if (bCheck == true) {
					continue;
				}
				
				
			}
			bvisitied[i] = true;
			save.push_back(stacks[i]);
			backtracking(k,cnt+1);
			save.pop_back();
			bvisitied[i]=false;
		}


	}
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	//음이 아닌 정수 x
	//가장 큰 자릿부터 작은 자릿 수까지 감소한다면 
	//예를들어 3 21 950 감소하느수지만
	//3 2 2 9588은 아닌다.
	//0은 0번째 감소
	//1은 1번째 감소하는수
	//n번째 감소하는수가 없으면 -1 출력
	
	cin >> n;
	if (n == 0) {
		cout << 0;
		return 0;
	}
	//gcnt = n;
	// 5: ,4 ,3 ,2, 1, 0          5
	// 4: ,3, 2, 1, 0             4
	// 3: ,2, 1, 0                3
	// 2: ,1, 0              2
	// 1: ,0                  1 
	// 0: 1 2 3 4 5 6 7 8 9  9
	//9개 이후
	/*
	if (n > 10) {
		//backtracking(10, 10);
	}
	else {
		
		maxs = n;
		
	}*/
	for (int i = 0; i <= 9; i++) {
		stacks.push_back(i);
		bvisitied.push_back(false);
	}
	for (int i = 1; i <= 10; i++)
	{
		backtracking(i, 0);
	}

	
	cout << maxstrt;
	
	return 0;
}