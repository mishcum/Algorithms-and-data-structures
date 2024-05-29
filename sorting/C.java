package hsejava.algorithms.topics.sorting;

import java.util.Arrays;
import java.util.Scanner;

class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] lst = new int[n];
        for (int i = 0; i < n; i++) {
            lst[i] = in.nextInt();
        }
        in.close();
        for (int i = 1; i < n; i++) {
            int key = lst[i];
            int j = i - 1;
            boolean c = false;
            for (; j >= 0; j--) {
                if (key < lst[j]) {
                    lst[j + 1] = lst[j];
                    c = true;
                } else {
                    break;
                }
            }
            lst[j + 1] = key;
            if (c) {
                String s = Arrays.toString(lst).replaceAll(",", "").replace("[", "").replace("]", "");
                System.out.println(s);
                
            }
        }
    }    
}
