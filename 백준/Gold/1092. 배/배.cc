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



int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	//지민 항구에서 일한다.
	//항구에 크레인 n대 잇고
	//1분에 박스를 하나씩 실을수잇다.
	//모든 크레인은 동시에 움직인다.

	//모든 박스를 배로 옮기는데 드는 시간의 최솟값을 구하여라

	int n,m;
	cin >> n;
	vector<long long>crains;
	vector < long long > boxs;
	for (int i = 0; i < n; i++) {
		long long tmp;
		cin >> tmp;
		crains.push_back(tmp);
	}
	
	
	cin >> m;
	for (int i = 0; i < m; i++) {
		long long tmp;
		cin >> tmp;
		boxs.push_back(tmp);
	}

	
	sort(crains.begin(), crains.end(),greater<>());
	sort(boxs.begin(), boxs.end(), greater<>());
	//for (int i = 0; i < n; i++) {
	int i = 0;
	int cnt = 0;
	bool bCheck = false;
	
	if (boxs[0]>crains[0]) {
		cout << -1;
		return 0;
	}
	
	while (!boxs.empty()) {
		int j = 0;
		for(int i=0;i<crains.size();i++){
			//for (int j = 0; j < boxs.size(); j++) {
				if (i>=n) {
					break;
				}

				if (j >= boxs.size()) {
					break;
				}

				if (boxs[j] <= crains[i]) {
					//cout << boxs[j] << "," << crains[i]<<endl;
					boxs.erase(boxs.begin() + j);
					//j--;
					//i++;
					continue;
				}
				else {
					
					//cout << boxs[j] << "," << crains[i] << endl;
					i--;
				}
				j++;
			//}
		}
		cnt++;

	}
	

	if (cnt == 0) {
		cout << -1;
	}
	else {
		cout << cnt;
	}
	
}