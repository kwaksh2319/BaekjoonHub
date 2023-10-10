#include <iostream>
#include <vector>
#include <algorithm>
#include<string>
#include<queue>
#include<map>
#include<stack>
#include<bitset>
using namespace std;

void Prints(vector<vector<char>>maps, int r, int c) {
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cout << maps[i][j];
		}
		cout << endl;
	}
	cout << endl;
}
void Prints(vector<vector<bool>>maps, int r, int c) {
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cout << maps[i][j];
		}
		cout << endl;
	}
	cout << endl;
}
void Prints(vector<vector<int>>maps, int r, int c) {
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cout << maps[i][j];
		}
		cout << endl;
	}
	cout << endl;
}
struct Point {
	int s;
	int e;
	int cnt;
};
struct Data {
	int index;
	int cnt;

};

int main() {

	//1~n
	//3,2,7,8,1,4,5,6
	int T;
	cin >> T;
	
	for (int z = 0; z < T; z++) {
		int n;
		cin >> n;
		vector<Point>maps;
		for (int i = 0; i < n; i++) {
			int tmp;
			cin >> tmp;
			Point p;
			p.s = i + 1;
			p.e = tmp;
			maps.push_back(p);
		}
		vector<bool>bCheck(n, false);
		queue<int>q;
		
		int count = 0;
		for (int k = 0; k < n; k++) {
			if (bCheck[k] == false) {
				count++;

				q.push(maps[k].e);
				bCheck[k] = true;
				
				while (!q.empty()) {
					int start = q.front();
					q.pop();
					for (int i = 0; i < n; i++) {
						if (start == maps[i].s&&bCheck[maps[i].s - 1] == false) {
							q.push(maps[i].e);
							bCheck[maps[i].s - 1] = true;

						}
					}
				}
			}
			
		
		}
		cout << count << endl;

	}
	
	

	return 0;
}