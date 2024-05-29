package hsejava.algorithms.topics.sixth;

import java.util.*;


class taskEsixth {
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        in.close();
        boolean[][] used = new boolean[n + 1][n + 1];
        used[x1][y1] = true;
        int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
        Deque<int[]> que = new ArrayDeque<>();
        int[] t = {x1, y1};
        que.push(t);
        int[][] moveCnt = new int[n + 1][n + 1];
        while (!que.isEmpty()) {
            int[] tm = que.pop();
            if (tm[0] == x2 && tm[1] == y2) {
                System.out.println(moveCnt[tm[0]][tm[1]]);
                break;
            }
            for (int i = 0; i < 8; i++) {
                int nx = tm[0] + dx[i];
                int ny = tm[1] + dy[i];
                if ((nx >= 1 && nx <= n && ny >= 1 && ny <= n) && !used[nx][ny]) {
                    used[nx][ny] = true;
                    moveCnt[nx][ny] = moveCnt[tm[0]][tm[1]] + 1;
                    int[] p = {nx, ny};
                    que.addLast(p);
                }
            }
        }
    }
}
