package hsejava.algorithms.topics.sorting;

import java.util.Scanner;

class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] lst = new int[n];
        int c = 0;
        for (int i = 0; i < n; i++) {
            lst[i] = in.nextInt();
        }
        in.close();
        for (int i = 1; i < lst.length; i++) {
            int key = lst[i];
            int j = i - 1;
            while (j >= 0 && lst[j] > key) {
                lst[j + 1] = lst[j];
                j -= 1;
            }
            if (lst[j + 1] == key) c += 1;
            lst[j + 1] = key;
        }
        for (int i = 0; i < lst.length; i++) {
            System.out.print(lst[i] + " ");
        }
        System.out.println("\n" + c);
    }
}
