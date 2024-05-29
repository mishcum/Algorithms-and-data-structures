package hsejava.algorithms.topics.sorting2;

import java.util.Scanner;

class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        in.close();
        long a = 1;
        long b = 1;
        long res = 0;
        for (int i = 0; i < x; i++) {
            if (a * a == b * b * b) {
                res = a * a;
                a ++;
                b ++;
            } else if (b * b * b > a * a) {
                res = a * a;
                a ++;
            } else if (a * a > b * b * b) {
                res = b * b * b;
                b ++;
            }   
        }
        System.out.println(res);
    }    
}
