#include <iostream>
#include <vector>
#include <unordered_map>
#include <climits>
#include <algorithm>
#include <set>

using namespace std;

vector<long> d1(unordered_map<int, vector<pair<int, int>>>& g, int n, int s) {
    vector<long> dist(n + 1, LONG_MAX);
    dist[s] = 0;
    set<pair<int, int>> q;
    q.insert({0, s});
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
    cin >> n;
    vector<int> cost (n + 1);
    for (int i = 1; i < n + 1; i++) {
        int l;
        cin >> l;
        cost[i] = l;
    }
    cin >> m;
    unordered_map<int, vector<pair<int, int>>> g;
    for (int i = 1; i <= m; i++) {
        int v, u;
        cin >> v >> u;
        g[v].push_back({u, cost[v]});
        g[u].push_back({v, cost[u]});
    }
    vector<long> res = d1(g, n, 1);
    cout << (res[n] != LONG_MAX ? res[n] : -1) << endl;
    return 0;
}

