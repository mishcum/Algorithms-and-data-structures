package hsejava.algorithms.topics.sorting2;

import java.util.Scanner;

public class E {
    public static int randPRT(int[][] array, int p, int r) {
        int i = p + (int) (Math.random() * (r - p + 1));
        int[] temp = new int[2];
        temp = array[r];
        array[r] = array[i];
        array[i] = temp;
        return part(array, p, r);
    }
    public static void randQS(int[][] array, int p, int r) {
        int q;
        if (p < r) {
         q = randPRT(array, p, r);
         randQS(array, p, q - 1);
         randQS(array, q + 1, r);
        }
    }
    public static int part(int[][] array, int p, int r) {
        int[] temp, temp1;
        int x = array[r][0];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (array[j][0] < x) {
                i += 1;
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        temp1 = array[i + 1];
        array[i + 1] = array[r];
        array[r] = temp1;
        return i + 1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = i + 1;
        }
        int m = in.nextInt();
        int[][] arr2 = new int[m][2];
        for (int i = 0; i < m; i++) {
            arr2[i][0] = in.nextInt();
            arr2[i][1] = i + 1;
        }
        in.close();
        randQS(arr, 0, n - 1);
        randQS(arr2, 0, m - 1);
        int[] res = new int[n];
        int c = 0;
        for (int i = 0; i < n; i++) {
            int temp = 1_000_000_000 + 1;
            for (int j = c; j < m; j++) {
                if (Math.abs(arr[i][0] - arr2[j][0]) < temp) {
                    temp = Math.abs(arr[i][0] - arr2[j][0]);
                    res[arr[i][1] - 1] = arr2[j][1];
                    c = j;
                } else break;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }   
    }
}
