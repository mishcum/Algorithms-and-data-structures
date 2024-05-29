package hsejava.algorithms.topics.Graphs;

import java.util.Scanner;

class A {
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
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {count++;}
            }
            System.out.print(count + " ");
            for (int l = 0; l < n; l++) {
                if (matrix[i][l] == 1) {
                    System.out.print(l + 1 + " ");
                }
            }
            System.out.println();
        }
    }
}
