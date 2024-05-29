package hsejava.algorithms.topics.sixth;

import java.util.*;

public class taskIsixth {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            int chest = in.nextInt();
            List<Integer> adjList = graph.get(chest);
            adjList.add(i);
        }
        in.close();
        int count = 0;
        int[] color = new int[n + 1];
        Stack<Integer> stack = new Stack<>();
        for (int vertex : graph.keySet()) {
            if (color[vertex] == 0) {
                stack.push(vertex);
                while (!stack.isEmpty()) {
                    int v = stack.peek();
                    if (color[v] == 0) {
                        color[v] = 1;
                        for (int neigh : graph.get(v)) {
                            if (color[neigh] == 0) {
                                stack.push(neigh);
                            } else if (color[neigh] == 1) {
                                count++;
                            }
                        }
                    } else if (color[v] == 1) {
                        color[v] = 2;
                        stack.pop();
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        System.out.println(count);
    }
}
