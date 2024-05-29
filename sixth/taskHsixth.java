package hsejava.algorithms.topics.sixth;

import java.util.*;

class taskHsixth {
    public static int[] getLenOfsqr(String[] matrix, int i) {
        String s = matrix[i];
        int[] len = new int[2];
        int st = 0;
        while (s.charAt(st) == '#') {st++;}
        len[0] = st;
        st = s.length() - 1;
        while (s.charAt(st) == '#') {st--;}
        len[1] = st;
        return len;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        //int w = in.nextInt();
        String[] matrix = new String[h];
        for (int i = 0; i < h; i++) {
            matrix[i] = in.next();
        } 
        in.close();
        int[] len = getLenOfsqr(matrix, 0);
        int cnt = len[1] - len[0] + 1;
        for (int i = 1; i < h; i++) {
            int[] len1 = getLenOfsqr(matrix, i);
            if (((len1[0] >= len[0] && len1[0] <= len[1]) || (len[1] >= len1[0] && len[1] <= len1[1])) || ((len[0] >= len1[0] && len[0] <= len1[1]) || (len[1] >= len1[0] && len[1] <= len1[1]))) {
                cnt += len1[1] - len1[0] + 1;
                len = len1;
            }
            else {
                break;
            }
        }
      
        System.out.println(cnt);
    }
}
