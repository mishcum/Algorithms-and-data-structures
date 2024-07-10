package hsejava.algorithms.topics.Graphs;

import java.util.ArrayList;
import java.util.Scanner;

class D {
    public static void dfs(int[][] matrix, int v, ArrayList<Integer> used) {
        if (!used.contains(v)) {
            used.add(v);
            for (int u = 0; u < matrix[v].length; u++) {
                if (!used.contains(u) && matrix[v][u] == 1) {
                    dfs(matrix, u, used);
                }    
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        in.close();
        ArrayList<Integer> used = new ArrayList<>();
        dfs(matrix, t - 1, used);
        System.out.println(used.size());
    }
}
