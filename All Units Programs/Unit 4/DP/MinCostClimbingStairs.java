package DP;
import java.util.*;
public class MinCostClimbingStairs {
    public int minCostRecur(int n, int[] cost) {
        return Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }

    private int minCost(int[] cost, int n) {
        if (n < 0)
            return 0;
        if (n == 0 || n == 1)
            return cost[n];
        return cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }

    public int minCostMemoized(int n, int[] cost, int[] dp) {
        if (n < 0)
            return 0;
        if (n == 0 || n == 1)
            return dp[n];
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = cost[n] + Math.min(minCostMemoized(n - 1, cost, dp),minCostMemoized(n - 2, cost, dp));
    }

    int minimumCost(int n, int cost[]) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = cost[0];
        dp[1] = cost[1];
        int top = Math.min(minCostMemoized(n - 1, cost, dp), minCostMemoized(n - 2, cost, dp));
        return top;
    }

    public int minCostDP(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for (int i = 0; i < n; i++)
            ar[i] = sc.nextInt();
        System.out.println(new MinCostClimbingStairs().minCostRecur(n, ar));
        System.out.println(new MinCostClimbingStairs().minimumCost(n, ar));
        System.out.println(new MinCostClimbingStairs().minCostDP(ar));
        sc.close();
    }
}