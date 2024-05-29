package hsejava.algorithms.topics.Introduction;

import java.util.Arrays;
import java.util.Scanner;

class G {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        sc.close();
		int[] nmbrs = new int[n];
		boolean fl = true;
		for (int i = 0; i < n; i++) {
			nmbrs[i] = sc.nextInt();
		}
		Arrays.sort(nmbrs);
		for (int i = nmbrs[0]; i >= 1; i--) {
			fl = true;
			for (int j = 0; j < n; j++) {
				if (nmbrs[j] % i != 0) {
					fl = false;
					break;
				}
			}
			if (fl) {
				System.out.println(i);
				break;
			}
		}	
	} 
}
