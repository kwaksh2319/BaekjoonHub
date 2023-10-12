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
	int day;
	int cost;
};


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	//퇴사
	//n+1
	//n일 최대한 많은 상담을 하려한다
	//ti pi 
	//n=7
	//비서에게 최대한 많은 상담을 잡으라고 부탁을 했거
	//비서는 하루에 하나씩 서로 다른 사람의 상담을 잡아 놓앗다
	//각각의 상담은 상담을 완료하는데 걸리는 기간 ti pi이러진다
	//n=7
	long long n;
	cin >> n;
	vector<Data>lists;
	vector<int>sum(n+1,0);
	for (long long i = 0; i < n; i++) {
		int day,cost;
		cin >> day >> cost;
		Data d;
		d.day = day;
		d.cost = cost;
		
		lists.push_back(d);
		
	
	}
	int maxs = 0;
	for (int i = lists.size()-1; i >= 0; i--) {
		int nextday = lists[i].day + i;
		//cout << nextday << ",";
		
		if (nextday > n) {
			sum[i] = sum[i + 1];
			continue;
		}

		//maxs = max(lists[i].cost + sum[nextday], maxs );
		//cout << maxs << ",";
		sum[i] = max(sum[i+1], lists[i].cost + sum[nextday]);
	}
	
	sort(sum.begin(), sum.end(), greater<>());
	cout << sum[0];
	
	
	

	return 0;
}