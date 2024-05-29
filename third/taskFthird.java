package hsejava.algorithms.topics.third;

import java.util.Scanner;

class taskFthird {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //String n = in.nextLine();
        String s = in.nextLine();
        in.close();
        int[] arr = new int[123]; //индекс-код, зн - клв
        for (int i = 0; i < s.length(); i++) {
            int l = (int) s.charAt(i);
            arr[l] += 1;
        }
        String res = "";
        for (int i = 0; i < 123 ; i++) {
            if (arr[i] >= 2) {
                String temp = "";
                temp += (char) i;
                temp = temp.repeat(arr[i] / 2);
                res += temp;
                arr[i] = arr[i] % 2;
            }
        }
        String res1 = new StringBuilder(res).reverse().toString();
        for (int i = 0; i < 123; i++) {
            if (arr[i] == 1) {
                res += (char) i;
                break;
            }    
        }
        System.out.println(res + res1);
    }
}
