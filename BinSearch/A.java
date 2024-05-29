package hsejava.algorithms.topics.BinSearch;

import java.util.Scanner;

class A {
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
        if (array.length > r && array[r] == target) return r + 1;
        else return 0;
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
        if (l >= 0 && array[l] == target) return l + 1;
        else return 0;
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
        for (int i = 0; i < m; i++) {
            if (leftbsc(arr, arr2[i]) == 0 && rightbsc(arr, arr2[i]) == 0) System.out.println(0);
            else System.out.println(leftbsc(arr, arr2[i]) + " " +rightbsc(arr, arr2[i]));
        }
    } 
}
