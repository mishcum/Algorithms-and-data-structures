#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    cin >> n;
    vector<long long> stair (n + 1);
    stair[0] = 1;
    stair[1] = 1;
    stair[2] = 2;
    stair[3] = 4;
    for (int i = 4; i < n + 1; i++) {
        stair[i] = (stair[i - 1] + stair[i - 2] + stair[i - 3]) % (long long)(1000000000 + 7);
    }
    cout << stair[n] << endl;
}

