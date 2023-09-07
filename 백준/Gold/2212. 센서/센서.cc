#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int N, K;
    cin >> N >> K;

    vector<int> sensors(N);
    for(int i = 0; i < N; ++i) {
        cin >> sensors[i];
    }

    if(K >= N) {
        cout << 0 << '\n';
        return 0;
    }

    sort(sensors.begin(), sensors.end());

    vector<int> gaps(N - 1);
    for(int i = 0; i < N - 1; ++i) {
        gaps[i] = sensors[i + 1] - sensors[i];
    }

    sort(gaps.begin(), gaps.end(), greater<int>());

    int gapSum = 0;
    for(int i = 0; i < K - 1; ++i) {
        gapSum += gaps[i];
    }

    int result = sensors[N - 1] - sensors[0] - gapSum;

    cout << result << '\n';

    return 0;
}
