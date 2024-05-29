package hsejava.algorithms.topics.fourth;

import java.text.DecimalFormat;
import java.util.Scanner;

public class taskEfourth {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String m1 = in.nextLine();
        in.close();
        double m = Double.parseDouble(m1);
        double l = 0;
        double r = m;
        double res = 0;
        DecimalFormat f = new DecimalFormat("#.#######");
        //System.out.println(m);
        while (Math.abs(Math.pow(res, 2) + Math.sqrt(res) - m) > 0.000000001) {
            double mid = (l + r) / 2;
            if (mid * mid + Math.sqrt(mid) < m) {
                l = mid;
                res = mid;
            } else {
                r = mid;
                res = mid;
            }
        }
        System.out.println((f.format(res)).replace(",", "."));
    } 
}
