package hsejava.algorithms.topics.Strings;

import java.util.Scanner;

public class F {
    public static int[] manacher(String s) {
        int n = s.length();
        char[] t = new char[2 * n + 3];
        t[0] = '@';
        t[2 * n + 2] = '$';
        for (int i = 0; i < n; i++) {
            t[2 * i + 1] = '#';
            t[2 * i + 2] = s.charAt(i);
        }
        t[2 * n + 1] = '#';

        int[] p = new int[t.length];
        int center = 0, right = 0;
        for (int i = 1; i < t.length - 1; i++) {
            int mirror = 2 * center - i;
            if (right > i) {
                p[i] = Math.min(right - i, p[mirror]);
            }
            while (t[i + 1 + p[i]] == t[i - 1 - p[i]]) {
                p[i]++;
            }
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = p[2 * i + 2];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();
        int[] palindromes = manacher(s);

        for (int len : palindromes) {
            System.out.print(len + " ");
        }
    }
}

