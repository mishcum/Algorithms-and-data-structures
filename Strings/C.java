package hsejava.algorithms.topics.Strings;

import java.util.Scanner;

public class C {
    public static boolean check(String s, int subLen) {
        String sub = s.substring(0, subLen);
        for (int j = subLen; j < s.length(); j += subLen) {
            if (!s.substring(j, j + subLen).equals(sub)) {
                return false;
            }
        }
        return true;
    }
    
    public static int findMaxK(String s) {
        int n = s.length();
        for (int i = n; i > 0; i--) {
            if (n % i == 0) {  
                if (check(s, n / i)) {
                    return i;
                }
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();
        System.out.println(findMaxK(s));
    }
}
