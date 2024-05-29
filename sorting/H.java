package hsejava.algorithms.topics.sorting;
//TL
import java.util.Scanner;

class H {
    public static long summ(long[] array) {
        long s = 0;
        for (long num : array) {
            s += num;
        }
        return s;
    }
    public static long[] sift_down(long[] array, int i) {
        int size = array.length;
        while (2 * i + 1 < size) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int big = left;
            if (right < size && array[right] > array[left]) big = right;
            if (array[big] <= array[i]) break;
            long temp = array[big];
            array[big] = array[i];
            array[i] = temp;
            i = big;
        }
        return array; 
    }
    public static long[] sift_up(long[] array, int i) {
        while (array[i] > array[(i - 1) / 2]) {
            long temp = array[i];
            array[i] = array[(i - 1) / 2];
            array[(i - 1) / 2] = temp;
            i = (i - 1) / 2;
        }
        return array;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = in.nextInt();
        }
        int a = in.nextInt();
        int b = in.nextInt();
        in.close();
        long[] arr3 = new long[n];
        for (int i = 0; i < n; i++) {
            arr3[i] =  (arr1[i] > arr2[i]) ? (arr1[i] - arr2[i]) : (arr2[i] - arr1[i]);
            arr3 = sift_up(arr3, i);
        }    
        long c = a + b;
        if (c >= summ(arr3)) System.out.println(0);
        else {
            while (c > 0) {
                arr3[0] --;
                c --;
                arr3 = sift_down(arr3, 0);
            }
            long sum = 0;
            for (long num : arr3) {
                sum += num * num;
            }
            System.out.println(sum);
        }
    }
}
