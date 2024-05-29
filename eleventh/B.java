package hsejava.algorithms.topics.eleventh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class B {
    public static int[][] lsc(int[] p1, int[] p2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (p1[i - 1] == p2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp;
    }

    public static ArrayList<Integer> get_lsc(int[] p1, int[] p2, int[][] dp, int n, int m) {
        ArrayList<Integer> lsc_str = new ArrayList<>();
        int i = n;
        int j = m;
        while (i > 0 && j > 0) {
            if (p1[i - 1] == p2[j - 1]) {
                lsc_str.add(p1[i - 1]);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        Collections.reverse(lsc_str);
        return lsc_str;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p1 = new int[n];
        for (int i = 0; i < n; i++) {
            p1[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] p2 = new int[m];
        for (int i = 0; i < m; i++) {
            p2[i] = in.nextInt();
        }
        in.close();
        System.out.println((get_lsc(p1, p2, lsc(p1, p2, n, m), n, m)).toString().replaceAll(",", "").replace("]", "").replace("[", ""));
    }
}
