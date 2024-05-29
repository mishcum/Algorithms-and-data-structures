package hsejava.algorithms.topics.seventh;

import java.util.*;

class taskDseventh {
    public static void dfs(HashMap<Integer, ArrayList<Integer>> g, int v, int p, boolean[] used, int[] tin, int[] up, int time, ArrayList<Integer> bridges, HashMap<String, Integer> numbering) {
        used[v] = true;
        tin[v] = time;
        up[v] = time;
        time++;
        if (true) {
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
                                if (!bridges.contains(numbering.get(Math.min(u, v) + " " + Math.max(u, v))) /*&& Collections.frequency(g.get(v), u) == 1*/) {
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
        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                dfs(g, i, -1, used, tin, up, time, bridges, numbering);
            }
        }
        Collections.sort(bridges);
        System.out.println(bridges.size());
        //System.out.println(bridges.toString().replaceAll(",", "").replace("[", "").replace("]", ""));
        for (int i = 0; i < bridges.size(); i++) {System.out.println(bridges.get(i));}
    }
}
