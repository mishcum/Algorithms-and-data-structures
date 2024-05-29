package hsejava.algorithms.topics.eleventh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class C {
    public static int[] findLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; 
        int[] prev = new int[n]; 
        Arrays.fill(prev, -1);
        int length = 0; 
        int lastIndex = 0; 
        for (int i = 0; i < n; i++) {
            dp[i] = 1; 
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > length) {
                length = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> lis = new ArrayList<>();
        for (int i = lastIndex; i >= 0; i = prev[i]) {
            lis.add(0, nums[i]);
            if (prev[i] == -1) {
                break;
            }
        }

        int[] result = new int[lis.size()];
        for (int i = 0; i < lis.size(); i++) {
            result[i] = lis.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        in.close();
        int[] lis = findLIS(nums);
        System.out.println(Arrays.toString(lis).replace("]", "").replace("[", "").replaceAll(",", ""));
    }
}
