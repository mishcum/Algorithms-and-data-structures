package hsejava.algorithms.topics.sixth;

import java.util.*;

class taskBsixth {
    public static boolean dfs(int[][] matrix, boolean[] used, int v, int p) {
        used[v] = true;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[v][i] == 1) {
                if (!used[i]) { 
                    if (!dfs(matrix, used, i, v)) {
                        return false;
                    }
                } else if (i != p) { 
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double cnt = 0;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
                if (matrix[i][j] == 1) {cnt += .5;}
            }
        }
        in.close();
        if (cnt != n - 1) {
            System.out.println("NO");
            System.exit(0);
        }
        boolean[] used = new boolean[n];
        if (!dfs(matrix, used, 0, -1)) {
            System.out.println("NO");
            System.exit(0);
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }
}
