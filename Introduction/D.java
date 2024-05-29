package hsejava.algorithms.topics.Introduction;

import java.util.Scanner;

class D {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double a = in.nextDouble();
		double b = in.nextDouble();
		double c = in.nextDouble();
        in.close();
		if (0 < (1.5 * a + .5 * b - .5 * c)) {
        	System.out.println((long) Math.ceil(a + (b - c)/3));
		} else {
			System.out.println(0);
        }    
	}	
}
