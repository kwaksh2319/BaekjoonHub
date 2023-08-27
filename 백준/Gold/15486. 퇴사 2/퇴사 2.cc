#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Consult {
    int T;
    int P;
};

int main() {
    int n;
    cin >> n;
    vector<Consult> consult(n);
    for (int i = 0; i < n; i++) {
        cin >> consult[i].T;
        cin >> consult[i].P;
    }

    vector<int> dp(n + 1, 0);
    int maxSum = 0;

    for (int i = n - 1; i >= 0; i--) {
        int futureDay = i + consult[i].T;

        if (futureDay > n) {
            dp[i] = dp[i + 1];
        } else {
            dp[i] = max(consult[i].P + dp[futureDay], dp[i + 1]);
        }

        maxSum = max(maxSum, dp[i]);
    }

    cout << maxSum << endl;

    return 0;
}