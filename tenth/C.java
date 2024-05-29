package hsejava.algorithms.topics.tenth;

import java.io.*;
import java.util.*;

class С {
    static class SegmentTree {
        private class Node {
            int maxValue;
            int count;

            Node(int maxValue, int count) {
                this.maxValue = maxValue;
                this.count = count;
            }
        }

        private Node[] tree;
        private int n;

        public SegmentTree(int[] arr) {
            n = arr.length;
            tree = new Node[4 * n];
            build(arr, 0, 0, n - 1);
        }

        private void build(int[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = new Node(arr[start], 1);
            } else {
                int mid = (start + end) / 2;
                build(arr, 2 * node + 1, start, mid);
                build(arr, 2 * node + 2, mid + 1, end);
                tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
            }
        }

        private Node merge(Node left, Node right) {
            if (left.maxValue > right.maxValue) {
                return new Node(left.maxValue, left.count);
            } else if (left.maxValue < right.maxValue) {
                return new Node(right.maxValue, right.count);
            } else {
                return new Node(left.maxValue, left.count + right.count);
            }
        }

        public Node query(int l, int r) {
            return query(0, 0, n - 1, l, r);
        }

        private Node query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) {
                return new Node(Integer.MIN_VALUE, 0);
            }
            if (l <= start && end <= r) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            Node leftResult = query(2 * node + 1, start, mid, l, r);
            Node rightResult = query(2 * node + 2, mid + 1, end, l, r);
            return merge(leftResult, rightResult);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int k = Integer.parseInt(reader.readLine());
        SegmentTree segmentTree = new SegmentTree(arr);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < k; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int l = Integer.parseInt(tokenizer.nextToken()) - 1;
            int r = Integer.parseInt(tokenizer.nextToken()) - 1;
            SegmentTree.Node queryResult = segmentTree.query(l, r);
            result.append(queryResult.maxValue).append(" ").append(queryResult.count).append("\n");
        }

        System.out.print(result.toString());
    }
}
