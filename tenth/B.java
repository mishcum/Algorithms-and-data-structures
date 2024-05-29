package hsejava.algorithms.topics.tenth;

import java.util.*;

class B {
    static class MinSegmentTree {

        private final int N = 100_000 + 1;  
        private int[] tree = new int[N * 4];

        public MinSegmentTree(int[] arr) {

            build(arr, 0, 0, N - 1);

        }

        private void build(int[] arr, int node, int start, int end) {
            if (start == end) {
                this.tree[node] = arr[start]; 
            } else {
                int mid = (start + end) / 2;
                build(arr, 2 * node + 1, start, mid);
                build(arr, 2 * node + 2, mid + 1, end);
                this.tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
            }
        }

        public int min_on_seg(int l, int r) {
            return get_min(0, 0, this.N - 1, l, r);
        }

        private int get_min(int node, int start, int end, int l, int r) {
            if (r < start || end < l) {
                return Integer.MAX_VALUE;
            }
            if (l <= start && end <= r) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            int leftMin = get_min(2 * node + 1, start, mid, l, r);
            int rightMin = get_min(2 * node + 2, mid + 1, end, l, r);
            return Math.min(leftMin, rightMin);
        }

        public void update(int idx, int value) {
            update(0, 0, this.N - 1, idx, value);
        }
    
        private void update(int node, int start, int end, int idx, int value) {
            if (start == end) {
                tree[node] = value;
            } else {
                int mid = (start + end) / 2;
                if (start <= idx && idx <= mid) {
                    update(2 * node + 1, start, mid, idx, value);
                } else {
                    update(2 * node + 2, mid + 1, end, idx, value);
                }
                tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
            }
        }
    }

    static class MaxSegmentTree {

        private final int N = 100_000 + 1;  
        private int[] tree = new int[N * 4];
    
        public MaxSegmentTree(int[] arr) {
            build(arr, 0, 0, arr.length - 1);
        }
    
        private void build(int[] arr, int node, int start, int end) {
            if (start == end) {
                this.tree[node] = arr[start];
            } else {
                int mid = (start + end) / 2;
                build(arr, 2 * node + 1, start, mid);
                build(arr, 2 * node + 2, mid + 1, end);
                this.tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
            }
        }
    
        public int max_on_seg(int l, int r) {
            return get_max(0, 0, this.N - 1, l, r);
        }
    
        private int get_max(int node, int start, int end, int l, int r) {
            if (r < start || end < l) {
                return Integer.MIN_VALUE;
            }
            if (l <= start && end <= r) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            int leftMax = get_max(2 * node + 1, start, mid, l, r);
            int rightMax = get_max(2 * node + 2, mid + 1, end, l, r);
            return Math.max(leftMax, rightMax);
        }
    
        public void update(int idx, int value) {
            update(0, 0, this.N - 1, idx, value);
        }
    
        private void update(int node, int start, int end, int idx, int value) {
            if (start == end) {
                tree[node] = value;
            } else {
                int mid = (start + end) / 2;
                if (start <= idx && idx <= mid) {
                    update(2 * node + 1, start, mid, idx, value);
                } else {
                    update(2 * node + 2, mid + 1, end, idx, value);
                }
                tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
            }
        }
    }
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        
        int q = in.nextInt();

        int[] stream = new int[100_000 + 1];
        
        for (int i = 0; i < 100_000 + 1; i++) {
            stream[i] = (i * i) % 12345 + ((i * i) % 23456 * i) % 23456;
        }
        
        MaxSegmentTree mx = new MaxSegmentTree(stream);
        MinSegmentTree mn = new MinSegmentTree(stream);

        for (int i = 0; i < q; i++) {
            int x = in.nextInt(); int y = in.nextInt();
            if (x > 0 && x > y) {
                System.out.println(1);
            } else if (x > 0) {
                System.out.println(mx.max_on_seg(x, y) - mn.min_on_seg(x, y));
            } else if (x < 0) {
                mx.update(x * -1, y);
                mn.update(x * -1, y);
            }
        }
        in.close();
    }
}
