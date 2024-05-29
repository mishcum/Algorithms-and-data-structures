package hsejava.algorithms.topics.sorting2;

import java.util.Scanner;

class B {
    public static long[] split(long[] array) {
        if (array.length == 1 || array.length == 0) return array;
        long[] left = new long[array.length / 2];
        long[] right = new long[array.length - array.length / 2];
        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, left.length, right, 0, right.length);
        left = split(left);
        right = split(right);
        return merge(left, right);
    }

    public static long[] merge(long[] left, long[] right) {
        long[] res = new long[left.length + right.length];
        int i = 0, i1 = 0, i2 = 0;
        while (i1 < left.length && i2 < right.length) res[i++] = left[i1] <= right[i2] ? left[i1++] : right[i2++];
        while (i1 < left.length) res[i++] = left[i1++];
        while (i2 < right.length) res[i++] = right[i2++];
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.close();
        arr = split(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }    
}
