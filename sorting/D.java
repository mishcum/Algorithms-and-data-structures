package hsejava.algorithms.topics.sorting;

import java.util.Scanner;

class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] lst = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                lst[i][j] = in.nextInt();
            }
        }
        in.close();
        for (int j = 0; j < lst.length - 1; j++) {
            boolean per = false;
            for (int i = 0; i < lst.length - 1 - j; i++) {
                if (lst[i][1] < lst[i + 1][1]) {
                    int[] temp = lst[i];
                    lst[i] = lst[i + 1];
                    lst[i + 1] = temp;
                    per = true;
                }
                if (lst[i][1] == lst[i + 1][1] && lst[i][0] > lst[i + 1][0]) {
                    int[] temp1 = lst[i];
                    lst[i] = lst[i + 1];
                    lst[i + 1] = temp1;
                    per = true;
                }
            }
            if (!per) break;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(lst[i][j] + " ");
            }
            System.out.println();
        } 
    }    
}
