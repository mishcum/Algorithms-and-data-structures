package hsejava.algorithms.topics.ninth;

import java.util.*;

public class F {

    static void knapsack(int n, int w, short[] weights, long[] prices, ArrayList<Short> selectedWeights, ArrayList<Long> selectedPrices) {
        long[][] dp = new long[n + 1][w + 1];

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= w; ++j) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + prices[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int i = n, j = w;
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                selectedWeights.add(weights[i - 1]);
                selectedPrices.add(prices[i - 1]);
                j -= weights[i - 1];
            }
            --i;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int w = in.nextInt();
        
        short[] weights = new short[n];
        long[] prices = new long[n];
        
        for (int i = 0; i < n; ++i) {
            weights[i] = in.nextShort();
        }
        
        for (int i = 0; i < n; ++i) {
            prices[i] = in.nextLong();
        }
        
        ArrayList<Short> selectedWeights = new ArrayList<>();
        ArrayList<Long> selectedPrices = new ArrayList<>();
        
        knapsack(n, w, weights, prices, selectedWeights, selectedPrices);

        long totalPrice = 0;
        short totalWeight = 0;
        
        for (long price : selectedPrices) {
            totalPrice += price;
        }

        for (short weight : selectedWeights) {
            totalWeight += weight;
        }
        
        System.out.println(totalPrice);
        System.out.println(totalWeight);
        System.out.println(selectedWeights.size());
        
        for (short weight : selectedWeights) {
            System.out.print(weight + " ");
        }
        System.out.println();
        for (long price : selectedPrices) {
            System.out.print(price + " ");
        }
        
        in.close();
    }
}

