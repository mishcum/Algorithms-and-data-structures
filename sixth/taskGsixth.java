package hsejava.algorithms.topics.sixth;

import java.util.*;

class taskGsixth {
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
        int[] dist = new int[n];
        Deque<Integer> que = new ArrayDeque<>();
        que.addLast(t - 1);
        boolean[] used = new boolean[n];
        used[t - 1] = true;
        while (!que.isEmpty()) {
            int v = que.pop();
            for (int i = 0; i < matrix[v].length; i++) {
                if (matrix[v][i] == 1 && !used[i]) {
                    que.addLast(i);
                    used[i] = true;
                    dist[i] = dist[v] + 1;
                }
            }
        }
        int defoltDist = 0;
        int defoltV = t - 1;
        for (int i = 0; i < n; i++) {
            if (dist[i] == defoltDist && defoltV > i) {
                defoltV = i + 1;
                defoltDist = dist[i];
            } else if (dist[i] > defoltDist) {
                defoltDist = dist[i];
                defoltV = i;
            }
        }
        System.out.println(defoltV + 1);
    }    
}
