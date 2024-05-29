package hsejava.algorithms.topics.tenth;

import java.io.*;
import java.util.*;

public class B2 {
    private static final int MAX_N = 100000;
    private static final int MOD1 = 12345;
    private static final int MOD2 = 23456;

    static class SegmentTree {
        int[] maxTree, minTree, array;

        public SegmentTree(int[] arr) {
            int n = arr.length;
            maxTree = new int[4 * n];
            minTree = new int[4 * n];
            array = arr;
            build(0, 0, n - 1);
        }

        private void build(int node, int start, int end) {
            if (start == end) {
                maxTree[node] = array[start];
                minTree[node] = array[start];
            } else {
                int mid = (start + end) / 2;
                build(2 * node + 1, start, mid);
                build(2 * node + 2, mid + 1, end);
                maxTree[node] = Math.max(maxTree[2 * node + 1], maxTree[2 * node + 2]);
                minTree[node] = Math.min(minTree[2 * node + 1], minTree[2 * node + 2]);
            }
        }

        public void update(int idx, int value) {
            update(0, 0, array.length - 1, idx, value);
        }

        private void update(int node, int start, int end, int idx, int value) {
            if (start == end) {
                array[start] = value;
                maxTree[node] = value;
                minTree[node] = value;
            } else {
                int mid = (start + end) / 2;
                if (start <= idx && idx <= mid) {
                    update(2 * node + 1, start, mid, idx, value);
                } else {
                    update(2 * node + 2, mid + 1, end, idx, value);
                }
                maxTree[node] = Math.max(maxTree[2 * node + 1], maxTree[2 * node + 2]);
                minTree[node] = Math.min(minTree[2 * node + 1], minTree[2 * node + 2]);
            }
        }

        public int[] query(int l, int r) {
            return query(0, 0, array.length - 1, l, r);
        }

        private int[] query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) {
                return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
            }
            if (l <= start && end <= r) {
                return new int[]{maxTree[node], minTree[node]};
            }
            int mid = (start + end) / 2;
            int[] leftQuery = query(2 * node + 1, start, mid, l, r);
            int[] rightQuery = query(2 * node + 2, mid + 1, end, l, r);
            int maxVal = Math.max(leftQuery[0], rightQuery[0]);
            int minVal = Math.min(leftQuery[1], rightQuery[1]);
            return new int[]{maxVal, minVal};
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(reader.readLine());
        int[] P = new int[MAX_N + 1];
        
        for (int n = 1; n <= MAX_N; n++) {
            P[n] = (n * n % MOD1) + (n * n * n % MOD2);
        }
        
        SegmentTree segmentTree = new SegmentTree(P);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < k; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int xi = Integer.parseInt(tokenizer.nextToken());
            int yi = Integer.parseInt(tokenizer.nextToken());

            if (xi > 0) {
                if (xi > yi) {
                    result.append("1\n");
                } else {
                    int[] queryResult = segmentTree.query(xi, yi);
                    int maxVal = queryResult[0];
                    int minVal = queryResult[1];
                    result.append(maxVal - minVal).append("\n");
                }
            } else {
                int idx = -xi;
                segmentTree.update(idx, yi);
            }
        }

        System.out.print(result.toString());
    }
}

