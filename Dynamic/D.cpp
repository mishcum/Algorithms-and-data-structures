
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void ans(int k, int s, short* stones, vector<short>& res, short** matrix) {
    if (matrix[k][s] == 0) {
        return;
    } else if (matrix[k - 1][s] == matrix[k][s]) {
        ans(k - 1, s, stones, res, matrix);
    } else {
        ans(k - 1, s - stones[k - 1], stones, res, matrix);
        res.push_back(stones[k - 1]);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int n, w;
    cin >> n >> w;
    
    short* stones = new short[n];
    for (int i = 0; i < n; i++) {
        cin >> stones[i];
    }
    
    short** matrix = new short*[n + 1];
    for (int i = 0; i < n + 1; i++) {
        matrix[i] = new short[w + 1];
    }
    
    for (int i = 0; i < w + 1; i++) {
        matrix[0][i] = 0;
    }
    
    for (int i = 0; i < n + 1; i++) {
        matrix[i][0] = 0;
    }
    
    for (int k = 1; k < n + 1; k++) {
        for (int s = 1; s < w + 1; s++) {
            if (s >= stones[k - 1]) {
                matrix[k][s] = max(int(matrix[k - 1][s]), matrix[k - 1][s - stones[k - 1]] + stones[k - 1]);
            } else {
                matrix[k][s] = matrix[k - 1][s];
            }
        }
    }
    
    vector<short> res;
    ans(n, w, stones, res, matrix);
    
    int weight = 0;
    for (short a : res) {
        weight += a;
    }
    
    cout << weight << endl;
    sort(res.begin(), res.end());
    cout << res.size() << endl;
    for (int i = 0; i < res.size(); i++) {
        cout << res[i] << " ";
    }
    
    for (int i = 0; i < n + 1; i++) {
        delete[] matrix[i];
    }
    delete[] matrix;
    delete[] stones;
    
    return 0;
}

