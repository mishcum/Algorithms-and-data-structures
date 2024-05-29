package hsejava.algorithms.topics.seventh;

import java.util.*;

class taskEseventh {
    public static void dfs(HashMap<Integer, ArrayList<Integer>> g, int v, int p, int[] h, int[] d, boolean[] used, ArrayList<Integer> chlens) {
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
                    dfs(g, u, v, h, d, used, chlens);
                    d[v] = Math.min(d[v], d[u]);
                    if (h[v] <= d[u] && p != -1) {
                        if (!chlens.contains(v)) {
                            chlens.add(v);
                        }
                    }
                    child++;
                }
            }
        }
        if (p == -1 && child > 1) {
            if (!chlens.contains(v)) {
                chlens.add(v);
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        HashMap<Integer, ArrayList<Integer>> g = new HashMap<>(m);
        for (int i = 1; i <= n; i++) {g.put(i, new ArrayList<Integer>());}
        for (int i = 1; i <= m; i++) {
            int u = in.nextInt(); int v = in.nextInt();
            g.get(u).add(v);
            g.get(v).add(u);
        }
        in.close();
        int[] h = new int[n + 1];
        int[] d = new int[n + 1];
        boolean[] used = new boolean[n + 1];
        ArrayList<Integer> chlens = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                dfs(g, i, -1, h, d, used, chlens);
            }
        }
        Collections.sort(chlens);
        System.out.println(chlens.size());
        for (int i : chlens) {System.out.println(i);}
    }
}
