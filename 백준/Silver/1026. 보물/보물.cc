#include <iostream>
#include <vector>
#include <queue>
#include<string>
#include<algorithm>
#include<cmath>
#include<unordered_map>
#include<map>
using namespace std;

struct Point {
	int s, e, t, cnt;
	char c;
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


struct Data {
	int score;
	int index;
};

struct Word {
	std::string word;
	int count;
};
bool compare(const Point &a, const Point &b) {
	return a.e < b.e;
}

int main() {
	//
	int n;
	cin >> n;
	vector<int>A;
	vector<int>B;

	for (int i = 0; i < n; i++) {
		int tmpA;
		cin >> tmpA;
		A.push_back(tmpA);
	}
	for (int i = 0; i < n; i++) {
		int tmpB;
		cin >> tmpB;
		B.push_back(tmpB);
	}
	sort(A.begin(), A.end());
	sort(B.begin(), B.end(),greater<>());
	int sum = 0;
	for (int i = 0; i < n; i++) {
		sum +=( A[i] * B[i]);
	}
	cout << sum;
	return 0;
}