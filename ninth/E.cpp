#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, w;
    cin >> n >> w;
    vector<pair<int, int>> wp(n);
    for (short i = 0; i < n; i++) {
        cin >> wp[i].first;
    }
    for (short i = 0; i < n; i++) {
        cin >> wp[i].second;
    }
    
    for (int i = 0; i < n - 1; i++) {
        bool per = false;
        for (int j = 0; j < n - i - 1; j++) {
            if (((double) wp[j].second / (double) wp[j].first) < ((double) wp[j + 1].second / (double) wp[j + 1].first)) {
                swap(wp[j], wp[j + 1]);
                per = true;
            } else if (((double) wp[j].second / (double) wp[j].first) == ((double) wp[j + 1].second / (double) wp[j + 1].first) && wp[j].first < wp[j + 1].first) {
                swap(wp[j], wp[j + 1]);
                per = true;
            }
        }
        if (!per) {
            break;
        }
    }
    vector<pair<int, int>> res;
    int totalw = 0;
    long totalc = 0;
    vector<int> result, result2;
    for (int i = 0; i < n; i++) {
        if (wp[i].first <= w - totalw) {
            result.push_back(wp[i].first);
            totalw += wp[i].first;
            result2.push_back(wp[i].second);
            totalc += wp[i].second;
            
        }
    }
    cout << totalc << endl;
    cout << totalw << endl;
    cout << result.size() << endl;
    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << " ";
    }
    cout << "\n";
    for (int i = 0; i < result2.size(); i++) {
        cout << result2[i] << " ";
    }
    
    return 0;
}

