package DP;
class ZeroOneRecursion {
    static int knapSack(int maxWeight, int weight[], int profit[], int n) {
        // Base Case
        if (n == 0 || maxWeight == 0)
            return 0;
        // If weight of the nth item is more than Knapsack capacity W,
        // then this item cannot be included in the optimal solution
        if (weight[n - 1] > maxWeight)
            return knapSack(maxWeight, weight, profit, n - 1);
        // Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        else
            return Math.max(knapSack(maxWeight, weight, profit, n - 1),profit[n - 1] + knapSack(maxWeight - weight[n - 1], weight, profit, n - 1));
    }

    // Driver code
    public static void main(String args[]) {
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = profit.length;
        System.out.println(knapSack(W, weight, profit, n));
    }
}