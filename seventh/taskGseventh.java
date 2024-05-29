package hsejava.algorithms.topics.seventh;

import java.util.*;

class taskGseventh {
    public static void dfsg(HashMap<Integer, ArrayList<Integer>> g, int v, boolean[] used, ArrayList<Integer> ord) {
        used[v] = true;
        if (g.get(v) != null) {
            for (int u : g.get(v)) {
                if (!used[u]) {
                    dfsg(g, u, used, ord);
                }    
            }
        }
        ord.add(v);
    }

    public static void dfsgt(HashMap<Integer, ArrayList<Integer>> gt, int v, int[] comp, int compCnt) {
        comp[v] = compCnt;
        if (gt.get(v) != null) {
            for (int u : gt.get(v)) {
                if (comp[u] == 0) {
                    dfsgt(gt, u, comp, compCnt);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> gt = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            g.put(i, new ArrayList<Integer>());
            gt.put(i, new ArrayList<Integer>());
        }
        for (int i = 1; i <= m; i++) {
            int v = in.nextInt(); int u = in.nextInt();
            g.get(v).add(u);
            gt.get(u).add(v);
        }
        in.close();
        int compCnt = 1;
        int[] comp = new int[n + 1];
        boolean[] used = new boolean[n + 1];
        ArrayList<Integer> ord = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                dfsg(g, i, used, ord);
            }
        }
        for (int i = ord.size() - 1; i >= 0; i--) {
            if (comp[ord.get(i)] == 0) {
                dfsgt(gt, ord.get(i), comp, compCnt);
                compCnt++;
            }
        }
        System.out.println(compCnt - 1);
        for (int i = 1; i <= n; i ++) System.out.print(comp[i] + " ");
    }
}
