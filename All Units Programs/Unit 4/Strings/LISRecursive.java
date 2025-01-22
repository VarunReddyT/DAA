package Strings;
import java.util.*;

public class LISRecursive {
    /*
     * Iterate from i = 1 to i = nums.length - 1.
     * At each iteration, use a loop to iterate
     * from j = 0 to j = i - 1 (all the elements before i).
     * For each element before i, check if that element is smaller than nums[i].
     * Time complexity: Exponential
     * Space complexity: O(n)
     */

    public int lengthOfLISRecur(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, helper(nums, i));
        }
        return max;
    }

    protected int helper(int[] nums, int i) {
        if (i == 0)
            return 1;
        int longest = 1;
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j])
                longest = Math.max(longest, helper(nums, j) + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for (int i = 0; i < n; i++)
            ar[i] = sc.nextInt();
        System.out.println(new LISRecursive().lengthOfLISRecur(ar));
        sc.close();
    }
}