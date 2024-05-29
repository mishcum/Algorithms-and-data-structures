package hsejava.algorithms.topics.SegmentTree;

import java.util.*;

public class D {
    static class SegmentTree {
        private class Node {
            int open;
            int close;
            int maxLength;

            Node(int open, int close, int maxLength) {
                this.open = open;
                this.close = close;
                this.maxLength = maxLength;
            }

        }

        private Node[] tree;
        private int n;

        public SegmentTree(String s) {
            n = s.length();
            tree = new Node[4 * n];
            build(s, 0, 0, n - 1);
        }

        private void build(String s, int node, int start, int end) {
            if (start == end) {
                if (s.charAt(start) == '(') {
                    tree[node] = new Node(1, 0, 0);
                } else {
                    tree[node] = new Node(0, 1, 0);
                }
            } else {
                int mid = (start + end) / 2;
                build(s, 2 * node + 1, start, mid);
                build(s, 2 * node + 2, mid + 1, end);
                tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
            }
        }

        private Node merge(Node left, Node right) {
            int matched = Math.min(left.open, right.close);
            int open = left.open + right.open - matched;
            int close = left.close + right.close - matched;
            int maxLength = left.maxLength + right.maxLength + 2 * matched;
            return new Node(open, close, maxLength);
        }

        public Node query(int l, int r) {
            return query(0, 0, n - 1, l, r);
        }

        private Node query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) {
                return new Node(0, 0, 0);
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        SegmentTree segmentTree = new SegmentTree(s);

        int m = in.nextInt();

        for (int i = 0; i < m; i++) {
            int l = in.nextInt() - 1;
            int r = in.nextInt() - 1;

            SegmentTree.Node queryResult = segmentTree.query(l, r);
            System.out.println(queryResult.maxLength);
        }

        in.close();
    }
}
