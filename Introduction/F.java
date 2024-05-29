package hsejava.algorithms.topics.Introduction;

import java.util.Scanner;

class F {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        sc.close();
		int[] nmbrs = new int[1000000];
		nmbrs[0] = 2;
		nmbrs[1] = 3;
		int num = 2;
		while (nmbrs[n - 1] == 0) {
			for (int i = 5; i <= 1300000; i += 2) {
				boolean fl = true;
				for (int j = 2; j <= (int) (Math.sqrt(i) + 1); j++) {
					if (i % j == 0) {
						fl = false;
						break;
					}
				}
				if (fl) {
					nmbrs[num] = i;
					num += 1;
				}
				
			}
		}
		System.out.println(nmbrs[n - 1]);	
	}	
}
