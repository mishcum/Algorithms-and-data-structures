package hsejava.algorithms.topics.eleventh;

import java.util.Scanner;

public class A {
    public static int lsc(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(lsc(in.nextLine(), in.nextLine()));
        in.close();
    }
}
