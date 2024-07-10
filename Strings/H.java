package hsejava.algorithms.topics.Strings;

import java.util.Scanner;
//не решено
public class H {
    public static boolean compare(long[] w, long[] p) {
        if (p.length > w.length) {return false;}
        return (w[p.length - 1] == p[p.length - 1]);
    }
    public static long[] get_hash(String s) {
        int k = 31;
        long mod = (long) 1e9 + 7;

        long[] hash = new long[s.length()];
        long h = 0;
        long m = 1;
        for (int i = 0; i < s.length(); i++) {
            h = ((h + s.charAt(i) - 'a' + 1) * m) % mod;
            hash[i] = h;
            m = (m * k) % mod; 
        }
        return hash;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        long[][][] hashes = new long[n][2][];
        for (int i = 0; i < n; i++) {
            String word = in.nextLine();
            hashes[i][0] = get_hash(word);
            hashes[i][1] = get_hash(new StringBuilder(word).reverse().toString());
        }
        
        int m = in.nextInt();
        in.nextLine();
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            String pref = in.nextLine();
            for (int j = 0; j < n; j++) {
                if (compare(hashes[j][0], get_hash(pref)) && compare(hashes[j][1], get_hash(new StringBuilder(pref).reverse().toString()))) {
                    result[i]++;
                }
            }
        }
        in.close();
        for (int i = 0; i < m; i++) {
            System.out.println(result[i]);
        }
    }
}
