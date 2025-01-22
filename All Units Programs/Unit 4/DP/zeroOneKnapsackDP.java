package DP;
import java.util.*;

public class zeroOneKnapsackDP {
    // Returns the maximum value that can be put in a knapsack of capacity W
    static int KnapSackDP(int[] profit, int[] weight, int n, int maxWeight) {
        int i, w;
        int dp[][] = new int[n + 1][maxWeight + 1];
        // Build table dp[][] in bottom up manner
        for (i = 1; i <= n; i++) {
            for (w = 1; w <= maxWeight; w++) {
                if (w >= weight[i - 1]) // included
                {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight[i - 1]] + profit[i - 1]);
                } else // not included
                {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][maxWeight];
    }

    public static void main(String args[]) {
        int profit[] = new int[] { 6, 10, 12 };
        int weight[] = new int[] { 1, 2, 3 };
        int W = 5;
        int n = profit.length;
        System.out.println(KnapSackDP(profit, weight, n, W));
    }
}