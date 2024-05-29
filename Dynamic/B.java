package hsejava.algorithms.topics.Dynamic;

import java.util.*;
import java.lang.StringBuilder;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        in.close();
        for (int i = 1; i < m; i++) {
            matrix[0][i] += matrix[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            matrix[i][0] += matrix[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                matrix[i][j] += Math.max(matrix[i][j - 1], matrix[i - 1][j]);
            }
        }
        int i = n - 1; int j = m - 1;
        String result = "";
        while (i != 0 || j != 0) {
            if (i == 0) {
                for (int k = 0; k < j; k++) {
                    result += " R";
                }
                break;
            }
            if (j == 0) {
                for (int k = 0; k < i; k++) {
                    result += " D";
                }
                break;
            }
            if (matrix[i][j - 1] > matrix[i - 1][j]) {
                result += " R";
                j--;
            } else {
                result += " D";
                i--;
            }
        }
        System.out.println(matrix[n - 1][m - 1]);
        System.out.println(new StringBuilder(result).reverse().toString());
    }
}
