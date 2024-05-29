
#include <iostream>
#include <vector>

using namespace std;

long long horse(int n, int m, vector<vector<long long>>& board, int i, int j) {
    if (i < n && i >= 0 && j < m && j >= 0) {
        if (board[i][j] == -1) {
            board[i][j] = horse(n, m, board, i - 2, j + 1) + horse(n, m, board, i + 1, j - 2) + horse(n, m, board, i - 1, j - 2) + horse(n, m, board, i - 2, j - 1);
        }
    } else {
        return 0;
    }
    return board[i][j];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, m;
    cin >> n >> m;
    vector<vector<long long>> board(n, vector<long long>(m, -1));
    board[0][0] = 1;
    cout << horse(n, m, board, n - 1, m - 1) << endl;
    return 0;
}


