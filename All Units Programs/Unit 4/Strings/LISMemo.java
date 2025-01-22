package Strings;
import java.util.*;

public class LISMemo {
    // Time complexity: O(n^2)
    // Space complexity: O(n)
    public int lengthOfLISMemo(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, helper(nums, i, dp));
        }
        return max;
    }

    protected int helper(int[] nums, int i, int[] dp) {
        if (i == 0)
            return 1;
        if (dp[i] != 0)
            return dp[i];
        int longest = 1;
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j])
                longest = Math.max(longest, helper(nums, j, dp) + 1);
        }
        dp[i] = longest;
        return longest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for (int i = 0; i < n; i++)
            ar[i] = sc.nextInt();
        System.out.println(new LISMemo().lengthOfLISMemo(ar));
        sc.close();
    }
}