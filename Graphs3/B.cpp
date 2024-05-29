#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class DSU {
public:
    static const int MAX = 20000;
    int arr[MAX];
    int s[MAX];

    DSU(int n) {
        for (int i = 0; i < n + 1; i++) {
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
    
    int get(int ind) {
        return  arr[ind];
    }
};

int main() {
    int n, m;
    cin >> n >> m;
    DSU d(n);
    vector<vector<int>> edges(m, vector<int>(3));
    for (int i = 0; i < m; i++) {
        cin >> edges[i][0] >> edges[i][1] >> edges[i][2];
    }
    sort(edges.begin(), edges.end(), [](const vector<int>& a, const vector<int>& b) {
        return a[2] < b[2];
    });
    long long weight = 0;
    for (auto& a : edges) {
        if (d.lead(a[0]) != d.lead(a[1])) {
            d.Union(a[0], a[1]);
            weight += a[2];
        }
        
    }
    cout << weight << endl;
    return 0;
}



