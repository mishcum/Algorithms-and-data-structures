package hsejava.algorithms.topics.sorting;

import java.util.Scanner;

class E {
    public static int[] insert(int number, int[] heap, int c) {
        heap[c] = number;
        return heap;
    }
    public static int[] sift_down(int[] heap, int c, int i) {
        while (2 * i + 1 < c) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int j = left;
            if (right < c && heap[right] > heap[left]) {
                j = right;
            }
            if (heap[i] >= heap[j]) break;
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
            i = j;
        }
        return heap;
    }
    public static int[] sift_up(int[] heap, int c) {
        while (heap[c] > heap[(c - 1) / 2]) {
            int temp = heap[c];
            heap[c] = heap[(c - 1) / 2];
            heap[(c - 1) / 2] = temp;
            c = (c - 1) / 2;
        }
        return heap;
    } 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] comma = new int[n][2]; 
        for (int i = 0; i < n; i ++) {
            comma[i][0] = in.nextInt();
            if (comma[i][0] == 0) comma[i][1] = in.nextInt();
            else comma[i][1] = 0;
        }
        in.close();
        int[] heap = new int[100_000];
        int c = 0; 
        for (int i = 0; i < n; i++) {
            if (comma[i][0] == 0) {
                heap = insert(comma[i][1], heap, c);
                heap = sift_up(heap, c);
                c += 1;
            } else {
                System.out.println(heap[0]);
                heap[0] = heap[c - 1];
                c -- ;
                heap = sift_down(heap, c, 0);
            }
        }
    }    
}
