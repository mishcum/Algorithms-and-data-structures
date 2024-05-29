#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

long long dfs(unordered_map<int, vector<int>>& arr, int v, vector<bool>& used, vector<int>& p1, vector<int>& time) {
    used[v] = true;
    long long sum = time[v];
    if (arr.find(v) != arr.end()) {
        for (int i : arr[v]) {
            if (!used[i]) {
                sum += dfs(arr, i, used, p1, time);
            }
        }
    }
    p1.push_back(v + 1);
    return sum;
}

int main() {
    int n;
    cin >> n;

    vector<int> time(n);
    for (int i = 0; i < n; i++) {
        cin >> time[i];
    }

    unordered_map<int, vector<int>> arr;
    for (int i = 0; i < n; i++) {
        int k;
        cin >> k;
        arr[i] = vector<int>(k);
        for (int j = 0; j < k; j++) {
            cin >> arr[i][j];
            arr[i][j]--;
        }
    }

    vector<bool> used(n, false);
    vector<int> p1;
    cout << dfs(arr, 0, used, p1, time) << " " << p1.size() << endl;
    for (int i = 0; i < p1.size(); i++) {
        cout << p1[i] << " ";
    }

    return 0;
}
