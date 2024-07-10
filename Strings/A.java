package hsejava.algorithms.topics.Strings;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static int[] pi2(String s) {
        int n = s.length();
        int[] prefics = new int[n];
        for (int i = 1; i < n; i++) {
            int j = prefics[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = prefics[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            prefics[i] = j;
        }
        return prefics;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();
        System.out.println(Arrays.toString(pi2(s)).replace("[", "").replaceAll("]", "").replaceAll(",", ""));
    }
}
