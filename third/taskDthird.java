package hsejava.algorithms.topics.third;

import java.util.Scanner;

class taskDthird {
    public static int randPRT(int[] array, int p, int r) {
        int i = p + (int) (Math.random() * (r - p + 1));
        int temp;
        temp = array[r];
        array[r] = array[i];
        array[i] = temp;
        return part(array, p, r);
    }
    public static void randQS(int[] array, int p, int r) {
        int q;
        if (p < r) {
         q = randPRT(array, p, r);
         randQS(array, p, q - 1);
         randQS(array, q + 1, r);
        }
    }
    public static int part(int[] array, int p, int r) {
        int temp, temp1;
        int x = array[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (array[j] < x) {
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
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.close();
        randQS(arr, 0, n - 1);
        int c = 1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) c++;
        }
        //for (int i = 0; i < n; i++) {
           // System.out.print(arr[i] + " ");
       //}
       System.out.println(c);
    }    
}
