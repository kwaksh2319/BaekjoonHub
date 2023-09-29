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
	
	//수열 s가 어떤 수 sk를 기준으로 
	//s1<s2<<s3<<s4 .... s> s
	//10 20 30 25 20
	//10 20 30 40 
	// {10, 20, 30, 40}, {50, 40, 25, 10} 
	int n;
	cin >> n;
	vector<int>lists;
	vector<int>cnts1(n, 1);
	vector<int>cnts2(n, 1);
	vector<int>anw;
	if (n == 1) {
		cout << 1;
		return 0;
	}
	
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		lists.push_back(tmp);
	}
	
	for (int i = 0; i < lists.size(); i++) {
		int maxs1 = 0;
		int maxs2 = 0;
		int indexi = (lists.size() - 1) - i;
		for (int j = 0; j < i; j++) {
			
			if (lists[i] > lists[j]) {
			
				maxs1 =max(maxs1, cnts1[j] + 1);
				
			}
			
			int indexj = (lists.size() - 1) - j;
			if (lists[indexi] > lists[indexj]) {
				maxs2 = max(maxs2, cnts2[indexj] + 1);
			}
			//cout << endl;
		}
		cnts1[i] = max(maxs1, cnts1[i]);
		cnts2[ indexi ] = max( maxs2, cnts2[ indexi ]);
		//int tmpSum = cnts1[i]+ cnts2[indexi];
		//anw.push_back(tmpSum);
	}
	
	for (int i = 0; i < n; i++) {
		//cout << cnts1[i];
		//cout << cnts1[i]<<",";
		int tmpSum = cnts1[i]+ cnts2[ i ];
		anw.push_back(tmpSum);
	
	}
	sort(anw.begin(), anw.end(), greater<>());
	cout << anw[0] - 1;
	//cout << endl;
	//for (int i = 0; i < n; i++) {
		//cout << cnts1[i];
		//cout << cnts2[i] << ",";
		//int tmpSum = cnts1[i]+ cnts2[ i ];
		//anw.push_back(tmpSum);

	//}
	return 0;
}