package hsejava.algorithms.topics.sixth;

import java.util.Scanner;

class taskFsixth {
    public static void dfs(int[][] matrix, int[] color, int v) {
        color[v] = 1;
        for (int u = 0; u < matrix[v].length; u++) {
            if (matrix[v][u] == 1 && color[u] == 0) {
                dfs(matrix, color, u);
            }
            if (color[u] == 1 && matrix[v][u] == 1) {
                System.out.println(1);
                System.exit(0);
            }
        }
        color[v] = 2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        in.close();
        for (int i = 0; i < n; i++) {
            int[] color = new int[n];
            dfs(matrix, color, i);
        }    
        System.out.println(0);

    }
}