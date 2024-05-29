package hsejava.algorithms.topics.seventh;

import java.util.*;

class taskCseventh {
    public static void dfs(HashMap<Integer, ArrayList<Integer>> g, int v, int p, boolean[] used, int[] tin, int[] up, int time, ArrayList<Integer> bridges, HashMap<String, Integer> numbering) {
        used[v] = true;
        tin[v] = time;
        up[v] = time;
        time++;
        for (int u : g.get(v)) {
            if (u != v) {
                if (u == p) {
                    continue;
                }
                if (!used[u]) {
                    dfs(g, u, v, used, tin, up, time, bridges, numbering);
                    up[v] = Math.min(up[v], up[u]);
                    if (up[u] > tin[v]) {
                        if (numbering.containsKey(Math.min(u, v) + " " + Math.max(u, v))) {
                            if (!bridges.contains(numbering.get(Math.min(u, v) + " " + Math.max(u, v))) && Collections.frequency(g.get(v), u) == 1) {
                                bridges.add(numbering.get(Math.min(u, v) + " " + Math.max(u, v)));
                            }
                        } 
                    }    
                } else {
                    up[v] = Math.min(up[v], tin[u]);
                }
            }    
        }
    }
    public static int[] bfs(int s, int n, HashMap<Integer, ArrayList<Integer>> g) {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.addLast(s);
        boolean[] used = new boolean[n + 1];
        used[s] = true;
        int[] p = new int[n + 1];
        while (!que.isEmpty()) {
            int v = que.pop();
            for (int u : g.get(v)) {
                if (!used[u]) {
                    que.addLast(u);
                    p[u] = v;
                    used[u] = true;
                }
            }
        }
        return p;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();
        for (int i = 1; i <= n; i++) {g.put(i, new ArrayList<Integer>());}
        int m = in.nextInt();
        HashMap<String, Integer> numbering = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            int v = in.nextInt(); int u = in.nextInt();
            numbering.put(Math.min(u, v) + " " + Math.max(u, v), i);
            g.get(v).add(u);
            g.get(u).add(v);
        }
        in.close();
        boolean[] used = new boolean[n + 1];
        int[] tin = new int[n + 1];
        int[] up = new int[n + 1];
        int time = 0;
        ArrayList<Integer> bridges = new ArrayList<>();
        dfs(g, 1, -1, used, tin, up, time, bridges, numbering);
        int[] p = bfs(1, n, g);
        ArrayList<Integer> p1 = new ArrayList<>();
        p1.add(1);
        while (n != 1) {
            p1.add(1, n);
            n = p[n];
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < p1.size() - 1; i ++) {
            if (bridges.contains(numbering.get(Math.min(p1.get(i), p1.get(i + 1)) + " " + Math.max(p1.get(i + 1), p1.get(i))))) {
                res.add(numbering.get(Math.min(p1.get(i), p1.get(i + 1)) + " " + Math.max(p1.get(i + 1), p1.get(i))));
            }
        }
        System.out.println(res.size());
        Collections.sort(res);
        System.out.println(res.toString().replaceAll(",", "").replace("[", "").replace("]", ""));
    }
}