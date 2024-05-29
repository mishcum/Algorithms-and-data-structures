#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;

void dfs(unordered_map<int, vector<int>>& g, int v, int p, vector<bool>& used, vector<int>& tin, vector<int>& up, int& time, vector<int>& bridges, unordered_map<string, int>& numbering) {
    used[v] = true;
    tin[v] = time;
    up[v] = time;
    time++;
    for (int u : g[v]) {
        if (u != p) {
            if (!used[u]) {
                dfs(g, u, v, used, tin, up, time, bridges, numbering);
                up[v] = min(up[v], up[u]);
                if (up[u] > tin[v]) {
                    string key = to_string(min(u, v)) + " " + to_string(max(u, v));
                    if (numbering.find(key) != numbering.end() && find(bridges.begin(), bridges.end(), numbering[key]) == bridges.end() && count(g[v].begin(), g[v].end(), u) == 1) {
                        bridges.push_back(numbering[key]);
                    }
                }
            } else {
                up[v] = min(up[v], tin[u]);
            }
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    unordered_map<int, vector<int>> g;
    unordered_map<string, int> numbering;
    vector<bool> used(n + 1, false);
    vector<int> tin(n + 1), up(n + 1);
    vector<int> bridges;

    for (int i = 1; i <= n; i++) {
        g[i] = vector<int>();
    }

    for (int i = 1; i <= m; i++) {
        int v, u;
        cin >> v >> u;
        numbering[to_string(min(u, v)) + " " + to_string(max(u, v))] = i;
        g[v].push_back(u);
        g[u].push_back(v);
    }

    int time = 0;
    for (int i = 1; i <= n; i++) {
        if (!used[i]) {
            dfs(g, i, -1, used, tin, up, time, bridges, numbering);
        }
    }

    sort(bridges.begin(), bridges.end());

    cout << bridges.size() << endl;
    for (int i = 0; i < bridges.size(); i++) {
        cout << bridges[i] << endl;
    }

    return 0;
}
