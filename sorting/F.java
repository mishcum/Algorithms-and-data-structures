package hsejava.algorithms.topics.sorting;

import java.util.Scanner;

class F {
    public static int[] insert(int[] heap, int i, int c) {
        heap[c] = i;
        return heap;
    }
    public static int[] sift_up(int[] heap, int c) {
        while (heap[c] < heap[(c - 1) / 2]) {
            int temp = heap[c];
            heap[c] = heap[(c - 1) / 2];
            heap[(c - 1) / 2] = temp;
            c = (c - 1) / 2;
        }
        return heap;
    }
    public static int[] sift_down(int[] heap, int i, int c) {
        while (2 * i + 1 < c) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int j = left;
            if (right < c && heap[right] < heap[left]) j = right;
            if (heap[i] <= heap[j]) break;
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
            i = j;
        }
        return heap;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = 0;
        int[] heap = new int[n];
        for (int i = 0; i < n; i++) {
            c += 1;
            heap = insert(heap, in.nextInt(), c - 1);
            heap = sift_up(heap, c - 1);

        }
        in.close();
        for (int i = 0; i < n; i++) {
            System.out.print(heap[0] + " ");
            heap[0] = heap[c - 1];
            c -= 1;
            heap = sift_down(heap, 0, c);
        }
    }
}
