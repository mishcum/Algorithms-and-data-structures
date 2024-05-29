package hsejava.algorithms.topics.seventh;

import java.util.*;

class taskBseventh {
    public static void dfs(int v, HashMap<Integer, ArrayList<Integer>> s, boolean[] used, ArrayList<Integer> srt) {
        used[v] = true;
        if (s.get(v) != null) {
            for (int u : s.get(v)) {
                if (!used[u]) {
                    dfs(u, s, used, srt);
                }
            }
        }
        srt.add(0, v + 1);;
    }
    public static void top_sort(HashMap<Integer, ArrayList<Integer>> s, int n, boolean[] used, ArrayList<Integer> srt) {
        for (int v = 0; v < n; v++) {
            if (!used[v]) {
                dfs(v, s, used, srt);
            }
        }
    }
    public static void cycle(int v, HashMap<Integer, ArrayList<Integer>> s, int[] color) {
        color[v] = 1;
        if (s.get(v) != null) {
            for (int u : s.get(v)) {
                if (color[u] == 0) {
                    cycle(u, s, color);
                }
                if (color[u] == 1) {
                    System.out.println("No");
                    System.exit(0);
                }
            }
        }
        color[v] = 2;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        HashMap<Integer, ArrayList<Integer>> s = new HashMap<>();
        for (int i = 0; i < n; i++) {s.put(i, new ArrayList<Integer>());} 
        for (int i = 0; i < m; i++) {
            s.get(in.nextInt() - 1).add(in.nextInt() - 1);
        }   
        in.close();
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            int[] color = new int[n];
            cycle(i, s, color);
        }
        ArrayList<Integer> srt = new ArrayList<>();
        top_sort(s, n, used, srt);
        System.out.println("Yes");
        System.out.println(srt.toString().replaceAll(",", "").replace("[", "").replace("]", ""));
    }
}
