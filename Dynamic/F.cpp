#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void knapsack(int n, int w, short* weights, long* prices, vector<short>& selected_weights, vector<long>& selected_prices) {
    
    vector<vector<long>> dp(n + 1, vector<long>(w + 1, 0));

    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= w; ++j) {
            if (weights[i - 1] <= j) {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + prices[i - 1]);
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }

    int i = n, j = w;
    while (i > 0 && j > 0) {
        if (dp[i][j] != dp[i - 1][j]) {
            selected_weights.push_back(weights[i - 1]);
            selected_prices.push_back(prices[i - 1]);
            j -= weights[i - 1];
        }
        --i;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    short n, w;
    cin >> n >> w;
    
    short* weights = new short[n];
    long* prices = new long[n];
    
    for (short i = 0; i < n; ++i) {
        cin >> weights[i];
    }
    
    for (short i = 0; i < n; ++i) {
        cin >> prices[i];
    }
    
    vector<short> selected_weights;
    vector<long> selected_prices;
    
    knapsack(n, w, weights, prices, selected_weights, selected_prices);

    long total_price = 0;
    short total_weight = 0;
    
    for (int i = 0; i < selected_prices.size(); ++i) {
        total_price += selected_prices[i];
    }

    for (int i = 0; i < selected_weights.size(); ++i) {
        total_weight += selected_weights[i];
    }
    
    cout << total_price << endl;
    cout << total_weight << endl;
    cout << selected_weights.size() << endl;
    
    for (int i = 0; i < selected_weights.size(); ++i) {
        cout << selected_weights[i] << " ";
    }
    cout << "\n";
    for (int i = 0; i < selected_prices.size(); ++i) {
        cout << selected_prices[i] << " ";
    }
    
    delete[] weights;
    delete[] prices;

    return 0;
}

