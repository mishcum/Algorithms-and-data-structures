package hsejava.algorithms.topics.seventh;

import java.util.*;

class taskFseventh {
    public static void dfs(HashMap<Integer, ArrayList<Integer>> g, int v, int p, int[] h, int[] d, boolean[] used, ArrayList<Integer> chlens, int n) {
        used[v] = true;
        if (p == -1) {
            h[v] = 0;
            d[v] = 0;
        } else {
            d[v] = h[p] + 1;
            h[v] = h[p] + 1;
        }
        int child = 0;
        for (int u : g.get(v)) {
            if (u != p) {
                if (used[u]) {
                    d[v] = Math.min(d[v], h[u]);
                } else {
                    dfs(g, u, v, h, d, used, chlens, n);
                    d[v] = Math.min(d[v], d[u]);
                    if (h[v] <= d[u] && p != -1) {
                        if (!chlens.contains(v) && v > n) {
                            chlens.add(v);
                        }
                    }
                    child++;
                }
            }
        }
        if (p == -1 && child > 1 && v > n) {
            if (!chlens.contains(v)) {
                chlens.add(v);
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();
        for (int i = 1; i <= n + m; i++) {g.put(i, new ArrayList<Integer>());}
        for (int i = 1; i <= m; i++) {
            int v = in.nextInt(); int u = in.nextInt(); int p = in.nextInt();
            g.get(n + i).add(v);
            g.get(n + i).add(u);
            g.get(n + i).add(p);
            g.get(v).add(n + i);
            g.get(u).add(n + i);
            g.get(p).add(n + i);
        }
        in.close();
        int[] h = new int[n + 1 + m];
        int[] d = new int[n + 1 + m];
        boolean[] used = new boolean[n + 1 + m];
        ArrayList<Integer> chlens = new ArrayList<>();
        for (int i = 1; i <= n + m; i++) {
            if (!used[i]) {
                dfs(g, i, -1, h, d, used, chlens, n);
            }
        }
        Collections.sort(chlens);
        System.out.println(chlens.size());
        for (int i : chlens) {System.out.println(i - n);}
    }
}
