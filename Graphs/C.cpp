#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    cin >> n;
    int matrix[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> matrix[i][j];
        }
    }
    vector<int> stocks;
    vector<int> istocks;
    for (int i = 0; i < n; i++) {
		bool fl = true;
        bool fl2 = true;
        for (int j = 0; j < n; j++) {
        	if (matrix[j][i] == 1) {fl = false;}
            if (matrix[i][j] == 1) {fl2 = false;}
            if (!fl && !fl2) {
            	break;
            }
        }
        if (fl) {
        	istocks.push_back(i + 1);
        }
        if (fl2) {
            stocks.push_back(i + 1);
        }
    }
    cout << istocks.size() << endl;
    for (int i = 0; i < istocks.size(); i++) {
        cout << istocks[i] << endl;
    }
    cout << stocks.size() << endl;
    for (int i = 0; i < stocks.size(); i++) {
        cout << stocks[i] << endl;
    }
    return 0;
}
