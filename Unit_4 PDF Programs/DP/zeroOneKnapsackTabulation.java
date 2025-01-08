import java.util.*;

class ZeroOneTab {
    // Returns the maximum value that can be put in a knapsack of capacity W
    static int KnapSackDP(int[] val, int[] weight, int n, int wt) {
        int i, w;
        int dp[][] = new int[n + 1][wt + 1];
        // Build table dp[][] in bottom up manner
        for (i = 1; i <= n; i++) {
            for (w = 1; w <= wt; w++) {
                if (w >= weight[i - 1]) // included
                {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight[i - 1]] + val[i - 1]);
                } else // not included
                {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][wt];
    }

    public static void main(String args[]) {
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = profit.length;
        System.out.println(KnapSackDP(weight, profit, n, W));
    }
}
// Driver code