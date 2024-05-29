package hsejava.algorithms.topics.Introduction;

import java.util.Scanner;

class E {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        sc.close();
		int i = 2;
		boolean frs_pr = false;
		int count = 0;
		while (n != 1) {
			while (n % i == 0) {
				count += 1;
				n /= i;
			} 
			if (!frs_pr) {
				if (count == 1) {
					System.out.print(i);
					frs_pr = true;
				} else if (count > 1) {
					System.out.print(i + "^" + count);
					frs_pr = true;
				}
			} else {
				if (count == 1) {
					System.out.print("*" + i);
					frs_pr = true;
				} else if (count > 1) {
					System.out.print("*" + i + "^" + count);
					frs_pr = true;
				}
			}
			count = 0;
			i += 1;	
		}
	}	
}
