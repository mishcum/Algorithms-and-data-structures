package hsejava.algorithms.topics.Introduction;

import java.util.Scanner;

class B {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long a = in.nextLong();
        in.close();
		long fb1, fb2, fb;
		fb1 = 0;
		fb2 = 1;
		for (int i = 2; i <= a; i++) {
			fb = fb2 + fb1;
			fb1 = fb2;
			fb2 = fb;
		}
		System.out.println(fb2);
	} 
}
