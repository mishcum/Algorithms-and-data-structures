package hsejava.algorithms.topics.BinSearch;

import java.util.Scanner;

class C {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        long w = Scanner.nextLong();
        long h = Scanner.nextLong();
        long n = Scanner.nextLong();
        Scanner.close();
        long l = 0;
        long r = (w >= h) ? w * n : h * n;
        while (l < r) {
            long side = (r + l) / 2;
            long c = (side / h) * (side / w);
            if (c < n) l = side + 1;
            else r = side;
        }
        System.out.println(r);
        
    } 
}
