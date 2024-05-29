package hsejava.algorithms.topics.BinSearch;

import java.util.Scanner;

class F {
    public static int cowscounter(int[] array, int mid) {
        int temp = array[0];
        int cnt = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] - temp >= mid) {
                cnt++;
                temp = array[i];
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] st = new int[n];
        for (int i = 0; i < n; i++) st[i] = in.nextInt();
        in.close();
        int left = 0;
        int right = st[n - 1] - st[0] + 1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (cowscounter(st, mid) >= k) left = mid;
            else right = mid;
        }
        System.out.println(left);
    } 
}
