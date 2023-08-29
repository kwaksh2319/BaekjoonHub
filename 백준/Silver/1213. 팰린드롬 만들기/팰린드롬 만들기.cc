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
	int s, e;
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
	int index;
	char color = 'G';

};
struct GDatas {
	int change;
	int index;

	string times;

};


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	//임한수,임문빈
	//팰린드롬
	string anw;
	cin >> anw;
	map<char, int>mstr;
	int n= anw.length();
	for (int i = 0; i<n; i++) {
		//cout << i;
		mstr[anw[i]]++;
	}
	string tmp;
	string front = "";
	for (auto iter = mstr.begin(); iter != mstr.end(); iter++) {
		int m = iter->second / 2;
		mstr[iter->first]-= m;
		//cout <<iter->first <<","<< iter ->second<<endl;
		
		for (int i = 0; i < m; i++) {
			front += iter->first;
		}
		mstr[iter->first] -= m;
		//cout << iter->first << "," << iter->second << endl;
		//cout << front;
		//mstr[iter->first] -= m;
		//string back=front;
		//cout << front << ",";
		//reverse(back.begin(), back.end());
		
	}
	string middle = "";
	for (auto iter = mstr.begin(); iter != mstr.end(); iter++) {
		if (iter->second == 1) {
			if (middle.size() > 0) {
				if (middle[0] != iter->second) {
					cout << "I'm Sorry Hansoo" << endl;
					return 0;
				}
			}
			
			middle += iter->first;
		}
	}
	//cout << front;
	string back = front;
	reverse(back.begin(), back.end());
	//cout << back;
	//cout << front<<","<<back;
	//middle
	//if ( front ==""|| back=="" ) {
		//cout << "I'm Sorry Hansoo" << endl;
		//return 0;
	//}
	
	string tmpan = front+ middle + back;
	cout << tmpan;

	
}