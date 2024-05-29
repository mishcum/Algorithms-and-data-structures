package hsejava.algorithms.topics.eleventh;


import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static int[] findLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] lis = new int[n]; 
        int[] prev = new int[n]; 
        Arrays.fill(prev, -1);
        int length = 0;
        for (int i = 0; i < n; i++) {
            int pos = Arrays.binarySearch(dp, 0, length, nums[i]);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            dp[pos] = nums[i];
            if (pos > 0) {
                prev[i] = lis[pos - 1];
            }
            lis[pos] = i;
            if (pos == length) {
                length++;
            }
        }

        int[] result = new int[length];
        int k = lis[length - 1];
        for (int i = length - 1; i >= 0; i--) {
            result[i] = nums[k];
            k = prev[k];
        }

        return result;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int k = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        in.close();
        int[] sequence = new int[n];
        sequence[0] = a;
        for (int i = 1; i < n; i++) {
            sequence[i] = (sequence[i-1] * k + b) % m;
        }
        int[] lis = findLIS(sequence);
        for (int num : lis) {
            System.out.print(num + " ");
        }
    }
}
