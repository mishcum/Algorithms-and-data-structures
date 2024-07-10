package hsejava.algorithms.topics.Strings;

import java.util.Scanner;

public class G {
    public static int[] get_z(String s) {
        int n = s.length();
        int[] z = new int[n];
        z[0] = n;
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        in.nextLine(); 
        String s = in.nextLine();
        in.close();
        String s2 = new StringBuilder(s).reverse().toString();
        s += s2;
        int[] result = get_z(s);
        for (int i = length * 2 - 1; i >= length; i--) {
            System.out.print(result[i] + " ");
        }
        
    }
}
