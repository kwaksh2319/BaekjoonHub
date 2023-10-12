#include<iostream>
#include<vector>
#include<string>
#include<map>
#include<cmath>
#include<algorithm>
#include<queue>
using namespace std;
void Prints(vector<vector<int>>maps, int n, int m) {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cout << maps[n][m] << ",";
		}
		cout << endl;
	}
}
void Prints(vector<int>maps, int n) {
	for (int i = 0; i < maps.size(); i++) {

		cout << maps[i] << ",";

	}
}
struct Data {
	int index;
	int time;
	int cnt;
	//map<int,bool>bCheck;
	//vector<bool>bVisisted;
};
int main() {
	int n;//수빈
	int k;//동생
	//걸으면 1초후 x-1,x+1 
	//순간이동 1초후 2*x
	cin >> n >> k;
	if (n == k) {
		cout << 0;
	//	cout << 1;
		return 0;
	}
	/*

	if (n == 1 && k == 2) {
		cout << 1 << '\n';
		cout << 2;
		return 0;
	}
	if (abs(n - k) == 1) {
		cout << 1 << '\n';
		cout << 1 ;
		return 0;
	}*/
	queue<Data>q;
	vector<bool>bVisisted(100001, false);
	Data d;
	d.index = n;
	d.time = 0;
	d.cnt = 0;
	//d.bCheck[0]=true;
	//d.bVisisted = bVisisted;
	q.push(d);
	//int dir[] = {-1,1,2}
	bool bend = false;
	int min = 0;
	bool init = false;
	int mincnt = 0;
	while (!q.empty()) {
		Data start = q.front();
		bVisisted[start.index] = true;
		q.pop();
		if (bend == true) {
			break;
		}

		for (int i = 0; i < 3; i++) {
			int mv = 0;
			Data tmpd;
			if (i == 0) {
				mv = start.index * 2;
				tmpd.time = start.time;
				
			}
			else if (i == 1) {
				mv = start.index - 1;
				tmpd.time = start.time + 1;
			}
			else if (i == 2) {
				mv = start.index + 1;
				tmpd.time = start.time + 1;
			}

			if (mv < 0 || mv > 100000) {
				continue;
			}

			if (bVisisted[mv] == true) {
				continue;
			}
			//if (start.bCheck.find(mv) != start.bCheck.end()) {
			//	continue;
			//}
			
			bVisisted[mv] = true;
			if (mv == k) {
			   
				//cout << endl;
				//cout << mv;
				//cout << endl;
				bVisisted[mv] = false;
				if (init == false) {
					init = true;
					//cout << "time:" << tmpd.time << endl;
					min = tmpd.time;
					mincnt++;
					bend = true;
				//	bend = true;
				}
				else {
					if (min > tmpd.time) {
						min = tmpd.time;
					}
					else if (min < tmpd.time) {
						bend = true;
					}
				}
				
				
				continue;
			}


			tmpd.index = mv;

			tmpd.cnt = start.cnt + 1;
			//tmpd.bCheck = start.bCheck;
			//tmpd.bCheck[mv] = true;

			q.push(tmpd);
		}
	}
	cout << min;
	//cout << mincnt;

	return 0;
}