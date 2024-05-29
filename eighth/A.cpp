#include <iostream>
#include <vector>
#include <unordered_map>
#include <climits>
#include <algorithm>
#include <set>

using namespace std;

vector<long> d1(unordered_map<int, vector<pair<int, int>>>& g, int n, int s) {
    vector<long> dist(n, LONG_MAX);
    dist[s] = 0;
    set<pair<int, int>> q;
    q.insert({0,s });
    while (!q.empty()) {
        int v = q.begin()->second;
        q.erase(q.begin());
        for (auto [u, w] : g[v]) {
            if (dist[u] > dist[v] + w) {
                q.erase({dist[u], u});
                dist[u] = dist[v] + w;
                q.insert({dist[u], u});
            }
        }
    }
    return dist;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, m;
    cin >> n >> m;
    unordered_map<int, vector<pair<int, int>>> g;
    for (int i = 0; i < m; i++) {
        int v, u, w;
        cin >> v >> u >> w;
        g[v].push_back({u, w});
    }
    vector<long> res = d1(g, n, 0);
    for (int i = 1; i < n; i++) {
        cout << res[i] << "\n";
    }
    return 0;
}

