#include <iostream>
#include <vector>
#include <unordered_map>
#include <climits>
#include <algorithm>
#include <set>
#include <queue>


using namespace std;

int d1(vector<vector<int>> g, int n, int s) {
    vector<int> dist(n + 1, INT_MAX);
    dist[s] = 0;
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> que;
    que.push({0, s});
    while (!que.empty()) {
        auto [d, v] = que.top();
        que.pop();
        if (d > dist[v])
            continue;
        for (int j = 1; j <= n; j++) {
            if (g[v][j] != 0) {
                if (dist[j] > dist[v] + g[v][j]) {
                    dist[j] = dist[v] + g[v][j];
                    que.push({dist[j], j});
                }
            }
        }
    }
    return dist[n];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    unsigned short U, D, I, J, L;
    cin >> N >> U >> D >> I >> J >> L;
    vector<vector<int>> g(N + 1, vector<int>(N + 1));
    for (int i = 0; i < L; i++) {
        short size;
        cin >> size;
        vector<unsigned short> lift (size);
        for (int j = 0; j < size; j++) {
            unsigned short floor;
            cin >> floor;
            lift.push_back(floor);
        }
        for (int j = 1; j <= N; j++) {
            if (find(lift.begin(), lift.end(), j) != lift.end()) {
                for (unsigned short u : lift) {
                    if (u != j) {
                        g[j][u] = I + J;
                    }
                }
            }
        }
    }
    for (int i = 1; i <= N; i++) {
        if (i > 1) {
            g[i][i - 1] = D;
        }
        if (i < N) {
            g[i][i + 1] = U;
        }
    }
    cout << d1(g, N, 1) << endl;
    return 0;
}



