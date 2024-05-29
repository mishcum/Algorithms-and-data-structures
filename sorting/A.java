package hsejava.algorithms.topics.sorting;

import java.util.Scanner;

class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] lst = new int[n];
        int c = 0; 
        for (int i = 0; i < n; i++) {
            lst[i] = in.nextInt();
        }
        in.close();
        for (int j = 0; j < lst.length - 1; j++) {
            boolean per = false;
            for (int i = 0; i < lst.length - 1 - j; i++) {
                if (lst[i] > lst[i + 1]) {
                    int temp = lst[i];
                    lst[i] = lst[i + 1];
                    lst[i + 1] = temp;
                    per = true;
                    c += 1;
                }
            }
            if (!per) break;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(lst[i] + " ");
            
        }
        System.out.println("\n" + c);
    }    
}
