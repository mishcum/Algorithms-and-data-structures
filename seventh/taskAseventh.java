package hsejava.algorithms.topics.seventh;

import java.util.*;

class taskAseventh {
    public static long dfs(HashMap<Integer, int[]> arr, int v, boolean[] used, ArrayList<Integer> p1, int[] time) {
        used[v] = true;
        long sum = time[v];
        if (arr.get(v) != null) {
            for (int i : arr.get(v)) {
                if (!used[i]) {
                    sum += dfs(arr, i, used, p1, time);
                }
            }
        }   
        p1.add(v + 1);
        return sum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {time[i] = in.nextInt();}
        HashMap<Integer, int[]> arr = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            arr.put(i, new int[k]);
            for (int j = 0; j < k; j++) {
                arr.get(i)[j] = in.nextInt() - 1;
            }
        }
        in.close();
        boolean[] used = new boolean[n];
        ArrayList<Integer> p1 = new ArrayList<>();
        System.out.println(dfs(arr, 0, used, p1, time) + " " + p1.size());
        System.out.println(p1.toString().replaceAll(",", "").replace("[", "").replace("]", ""));
    }
}
