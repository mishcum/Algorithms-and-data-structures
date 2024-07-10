package hsejava.algorithms.topics.Strings;

import java.util.ArrayList;
import java.util.Scanner;

public class E {
    public static ArrayList<Integer> kmp(String s, String t) {
        String spec = t + "#" + s;
        int[] prefics = pi2(spec);
        int m = t.length();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = m + 1; i < spec.length(); i++) {
            if (prefics[i] == m) {
                result.add(i - 2 * m);
            }
        }
        if (result.size() == 0) {result.add(-1);}
        return result;
    }

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
        String t = in.nextLine();
        in.close();
        if (s.equals(t)) {
            System.out.println(0);
        } else {
            System.out.println(kmp(t + t, s).get(0));
        }
    }    
}

