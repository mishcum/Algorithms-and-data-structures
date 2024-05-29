package hsejava.algorithms.topics.Introduction;

import java.util.Scanner;

class C {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long a = in.nextLong();
        in.close();
		boolean c = true;
		for (long i = 2; i <= (long) (Math.sqrt(a) + 1); i++) {
			if (a % i == 0 && a != 2) {
				c = false;
				break;
			}
		}
		if (c) {
			System.out.println("prime");
		} else {
			System.out.println("composite");
		}
	} 
}
