#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;

void dfs(unordered_map<int, vector<int>>& g, int v, int p, vector<int>& h, vector<int>& d, vector<bool>& used, vector<int>& chlens, int n) {
    used[v] = true;
    if (p == -1) {
        h[v] = 0;
        d[v] = 0;
    } else {
        d[v] = h[p] + 1;
        h[v] = h[p] + 1;
    }
    int child = 0;
    for (int u : g[v]) {
        if (u != p) {
            if (used[u]) {
                d[v] = min(d[v], h[u]);
            } else {
                dfs(g, u, v, h, d, used, chlens, n);
                d[v] = min(d[v], d[u]);
                if (h[v] <= d[u] && p != -1) {
                    if (find(chlens.begin(), chlens.end(), v) == chlens.end() && v > n) {
                        chlens.push_back(v);
                    }
                }
                child++;
            }
        }
    }
    if (p == -1 && child > 1 && v > n) {
        if (find(chlens.begin(), chlens.end(), v) == chlens.end()) {
            chlens.push_back(v);
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    unordered_map<int, vector<int>> g;
    vector<int> h(n + m + 1), d(n + m + 1);
    vector<bool> used(n + m + 1, false);
    vector<int> chlens;

    for (int i = 1; i <= n + m; i++) {
        g[i] = vector<int>();
    }

    for (int i = 1; i <= m; i++) {
        int v, u, p;
        cin >> v >> u >> p;
        g[n + i].push_back(v);
        g[n + i].push_back(u);
        g[n + i].push_back(p);
        g[v].push_back(n + i);
        g[u].push_back(n + i);
        g[p].push_back(n + i);
    }

    for (int i = 1; i <= n + m; i++) {
        if (!used[i]) {
            dfs(g, i, -1, h, d, used, chlens, n);
        }
    }

    sort(chlens.begin(), chlens.end());

    cout << chlens.size() << endl;
    for (int i : chlens) {
        cout << i - n << endl;
    }

    return 0;
}
