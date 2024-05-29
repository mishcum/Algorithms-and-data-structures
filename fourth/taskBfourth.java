package hsejava.algorithms.topics.fourth;

import java.util.Scanner;

class taskBfourth {
    public static int leftbsc(int[] array, int target) {
        int l = -1;
        int r = array.length;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (array[mid] < target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (r < array.length) return r;
        else return -1;
    }
    public static int rightbsc(int[] array, int target) {
        int l = -1;
        int r = array.length;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (array[mid] <= target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        int n = Scanner.nextInt();
        int m = Scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Scanner.nextInt();
        }
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = Scanner.nextInt();
        }
        Scanner.close();
        //long start = System.nanoTime();
        for (int i = 0; i < m; i++) {
            if (leftbsc(arr, arr2[i]) == -1) System.out.println(arr[rightbsc(arr, arr2[i])]);
            else if (rightbsc(arr, arr2[i]) == -1) System.out.println(arr[leftbsc(arr, arr2[i])]);
            else System.out.println((Math.abs(arr[rightbsc(arr, arr2[i])] - arr2[i]) <= Math.abs(arr[leftbsc(arr, arr2[i])] - arr2[i])) ? arr[rightbsc(arr, arr2[i])] : arr[leftbsc(arr, arr2[i])] );
        }
        //long finish = System.nanoTime();
        //System.out.println("\n" + (finish - start) / 1_000_000 + "ms");
    } 
}
