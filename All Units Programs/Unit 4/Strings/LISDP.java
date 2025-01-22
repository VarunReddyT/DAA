package Strings;
import java.util.*;

public class LISDP {
    /*
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     * Initialize an array dp with length nums.length and all elements equal to 1.
     * dp[i] represents the length of the longest increasing subsequence that ends
     * with the element
     * at index i.
     * Iterate from i = 1 to i = nums.length - 1.
     * At each iteration, use a second for loop to iterate from j = 0 to j = i - 1
     * (all the elements
     * before i).
     * For each element before i, check if that element is smaller than nums[i].
     * If so, set dp[i] = max(dp[i], dp[j] + 1).
     * Return the max value from dp.
     */
    public int lengthOfLISDP(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        int longest = 0;
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            longest = Math.max(longest, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return longest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for (int i = 0; i < n; i++)
            ar[i] = sc.nextInt();
        System.out.println(new LISDP().lengthOfLISDP(ar));
        sc.close();
    }
}