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
};
int main() {
	int n;//수빈
	int k;//동생
	//걸으면 1초후 x-1,x+1 
	//순간이동 1초후 2*x
	cin >> n >> k;
	if (n == k) {
		cout << 0<<'\n';
		cout << 1;
		return 0;
	}
	/*if (n == k) {
		cout << 0 << '\n';
		cout << 0 ;
		return 0;
	}


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
	vector<int>bVisisted(100001, 0);
	Data d;
	d.index = n;
	d.time = 0;
	d.cnt = 0;
	q.push(d);
	//int dir[] = {-1,1,2}
	bool bend = false;
	int min = 0;
	int mincnt = 0;
	bool init = false;
	while (!q.empty()) {
		Data start = q.front();
		//bVisisted[start.index] = true;
		q.pop();
		if (bend == true) {
			break;
		}

		for (int i = 0; i < 3; i++) {
			int mv = 0;
			bool bChek = false;
			if (i == 0) {
				mv = start.index + 1;
				bChek = true;
			}
			else if (i == 1) {
				mv = start.index - 1;
				bChek = true;
			}
			else if (i == 2) {
				mv = start.index * 2;
				bChek = true;
			}
			if (bChek == false) {
				continue;
			}
			if (mv < 0 || mv > 100000) {
				continue;
			}
			if (bVisisted[mv] > 3) {
				continue;
			}
			bVisisted[mv]++;
			

			//bVisisted[mv] = true;
			
			if (mv == k) {
				//cout << start.time <<","<<mv << endl;
				//cout << start.time + 1;
				//cout << endl;
				//cout << mv;
				//cout << endl;
				if (init ==false) {
					min = start.time + 1;
					mincnt++;
					init = true;
					continue;
				}
				else if (min == start.time + 1&&init==true) {
					mincnt++;
					continue;
				}

				if (min < start.time + 1) {
					bend = true;
					i = 3;
					continue;
				}
				//if (abs(n - k) == 1) {
				//bVisisted[mv] = true;
				//}
				//
				//bVisisted[mv] --;
				//continue;
			}

			Data tmpd;
			tmpd.index = mv;
			tmpd.time = start.time + 1;
			tmpd.cnt = start.cnt + 1;
			q.push(tmpd);
		}
	}
	cout << min << '\n';
	cout << mincnt;

	return 0;
}