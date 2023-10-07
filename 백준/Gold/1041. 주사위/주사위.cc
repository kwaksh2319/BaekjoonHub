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
	int arrive;
	int weight;
};


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	long long n;
	cin >> n;
	vector<int>dice;
	long long sum = 0;
	int mindata = 100;
	for (long long i = 0; i < 6; i++) {
		int tmp;
		cin >> tmp;
		if (mindata > tmp) {
			mindata = tmp;
		}
		dice.push_back(tmp);
	}
	
	if (n == 0) {
		cout << 0;
		return 0;
	}
	if (n == 1) {
		sort(dice.begin(), dice.end());
		for (int i = 0; i < 5; i++) {
			sum += dice[i];
		}
		cout << sum;
		return 0;
	}
	
	//꼭지점
	long long edge = 0;
	long long edge1 = 0;
	int threeEdge=0;
	//0,1,2
	threeEdge = dice[0] + dice[1] + dice[2];
	//0,1,3
	threeEdge = min((dice[0] + dice[1] + dice[3]), threeEdge);
	//0,3,4
	threeEdge = min((dice[0] + dice[3] + dice[4]), threeEdge);
	//0,2,4
	threeEdge = min((dice[0] + dice[2] + dice[4]), threeEdge);
	//5,1,2
	threeEdge = min((dice[5] + dice[1] + dice[2]), threeEdge);
	//5,1,3
	threeEdge = min((dice[5] + dice[1] + dice[3]), threeEdge);
	//5,3,4
	threeEdge = min((dice[5] + dice[3] + dice[4]), threeEdge);
	//5,2,4
	threeEdge = min((dice[5] + dice[2] + dice[4]), threeEdge);
	edge1 = threeEdge;
	
	edge1 = edge1 * 4;
	//cout << "윗꼭지점:"<<edge1<<endl;
	long long edge2 = 0;
	long long edgedown = 0;
	int twoEdge = 0;
	//0,1
	twoEdge = dice[0] + dice[1];
	//0,2
	twoEdge = min(dice[0] + dice[2], twoEdge);
	//0,3
	twoEdge = min(dice[0] + dice[3], twoEdge);
	//0,4
	twoEdge = min(dice[0] + dice[4], twoEdge);

	//5,1
	twoEdge = min(dice[5] + dice[1], twoEdge);
	//5,2
	twoEdge = min(dice[5] + dice[2], twoEdge);
	//5,3
	twoEdge = min(dice[5] + dice[3], twoEdge);
	//5,4
	twoEdge = min(dice[5] + dice[4], twoEdge);

	//1,2
	twoEdge = min(dice[1] + dice[2], twoEdge);
	//1,3
	twoEdge = min(dice[1] + dice[3], twoEdge);
	//2,4
	twoEdge = min(dice[2] + dice[4], twoEdge);
	//3,4
	twoEdge = min(dice[3] + dice[4], twoEdge);

	edge2 = twoEdge;
	
	edgedown = edge2 * 4;
	//cout << "아래꼭지점:" << edgedown << endl;
	edge = edge1 + edgedown;
	//cout << "꼮지점:" << edge << endl;
	long long totlasums = 0;
	
		//윗변 //아래변 //옆면
	long long line = 0;

	long long downline = mindata *(n-2);
	
	for (long long i = 0; i < n - 2; i++) {
		line+=edge2;
	}
	
	line = line * 8;
	//cout << "윗변,옆변:" << line << endl;
	//나머지
	downline = downline * 4;
//	cout << "아랫변:" << downline << endl;
	long long mod = 0;
	mod = mindata * (n - 2)*(n - 2)*5;

	//cout << "나머지:" << mod << endl;
	totlasums = mod + line+edge+ downline;
	
	cout << totlasums;
	return 0;
}