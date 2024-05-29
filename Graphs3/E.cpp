#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class DSU {
public:
    static const int MAX = 100000;
    int arr[MAX];
    int s[MAX];

    DSU(int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = i;
            s[i] = 1;
        }
    }

    int lead(int v) {
        return (arr[v] == v) ? v : arr[v] = lead(arr[v]);
    }

    void Union(int u, int v) {
        u = lead(u);
        v = lead(v);
        if (s[u] > s[v]) {
            swap(u, v);
        }
        s[v] += s[u];
        arr[u] = v;
    }
    
    
};

int main() {
    int n, m;
    cin >> n >> m;
    DSU d(n);
    vector<vector<int>> edges(m, vector<int>(2));
    for (int i = 0; i < m; i++) {
        int v, u;
        cin >> v >> u;
        edges[i][0] = v;
        edges[i][1] = u;
    }
    int comps = n;
    long long weight = 0;
    for (auto& a : edges) {
        if (comps > 1) {
            if (d.lead(a[0]) != d.lead(a[1])) {
                d.Union(a[0], a[1]);
                comps--;
            }
            weight++;
        } else {
            break;
        }
    }
    cout << weight << endl;
    return 0;
}




