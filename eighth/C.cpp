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

bool compare(const vector<long>& a, const vector<long>& b) {
    if (a[1] == b[1]) {
        return a[0] < b[0];
    }
    return a[1] < b[1];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, m, k, c;
    cin >> n >> m >> k >> c;
    vector<vector<long>> targets (k);
    for (int i = 0; i < k; i++) {
        int l;
        cin >> l;
        targets[i].push_back(l);
    }
    unordered_map<int, vector<pair<int, int>>> g;
    for (int i = 0; i < m; i++) {
        int v, u, w;
        cin >> v >> u >> w;
        g[v].push_back({u, w});
        g[u].push_back({v, w});
    }
    vector<long> res = d1(g, n, c);
    for (int i = 0; i < k; i++) {
        targets[i].push_back(res[(targets[i][0])]);
    }
    sort(targets.begin(), targets.end(), compare);
    for (int i = 0; i < k; i++) {
        cout << targets[i][0] << " " << targets[i][1] << "\n";
    }
    return 0;
}

