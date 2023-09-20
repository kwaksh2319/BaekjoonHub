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
	//ac를 만들엇다
	//이언어애는 두가지 함수 뒤집기(R) 과 버리기 (D)
	//함수 R은 배열에 있는 수의 순서를 뒤집는 함수 12345 -> 54321
	//D는 첫번쨰 수를 버리는 함수 12345->2345
	//배열이 비어잇는데 D를 사용시 에러발생
	//함수는 조합에 사용할수 잇다
	//AB는 A를 수행한다음 바로이어서 B를 수행하는 함수이다
	//RDD는 배열 뒤집고 두수버리기 함수
	
	int T;
	cin >> T;
	vector<string>ganw;
	for (int z = 0; z < T; z++) {
		string p;
		cin >> p;
		int n;
		cin >> n;
		string arrays;
		cin >> arrays;
		//vector<int>datas;
		deque<int>datas;
		//int tmp = arrays[i] - '0';
	
		string tmp="";
		for (int i = 0; i < arrays.size(); i++) {
			
			if (arrays[i] == '[') {
				
				
				continue;
			}
			
			if (arrays[i] == ',') {
				int num = stoi(tmp);
				
				datas.push_back(num);
				tmp = "";
				
				continue;
			}

			if (arrays[i] == ']') {
				if (tmp == "") {
					continue;
				}
				
				int num=stoi(tmp);
				
				datas.push_back(num);
				tmp = "";
				
				continue;
			}
			
			
			tmp += arrays[i];
			

			

		}
		bool bCheck = false;
		//cout << "datasize:"<<datas.size() << endl;
		int RS = 0;
		vector<char>dir;
		for (int i = 0; i < p.size(); i++) {
			
			if (p[i] == 'R') {
				RS++;
				
			}
			else if (p[i] == 'D') {
				if (datas.size() > 0) {
					if (RS % 2 != 0) {
						datas.pop_back();
					}
					else {
						datas.pop_front();
					}
				}else {
					bCheck = true;
				}

				
				
				
			}
		}

		if (RS % 2 != 0) {
			reverse(datas.begin(), datas.end());
		}
		
		if (datas.size() == 0&&bCheck==false) {
			//bCheck = true;
			ganw.push_back("[]");
			continue;
		}

		string anw = "[";
		for (int i = 0; i < datas.size(); i++) {

			//cout << datas[i] << ",";
			string tmp=to_string(datas[i]) ;
			anw += tmp + ",";
		}

		//cout << endl;
		if (bCheck) {
			//cout << "error" << endl;
			ganw.push_back("error");
		}
		else {
			anw.pop_back();
			anw += "]";
		
			ganw.push_back(anw);
		}
		
	}
	for (int i = 0; i < T; i++) {
		cout << ganw[i] << endl;
	}
	
}