package DP;
import java.util.*;
public class OBSTMemoised {
    static int[][] dp;

    // A recursive function to calculate cost of optimal binary search tree
    static int optCost(int freq[], int i, int j) {
        // Base cases
        if (j < i) // no elements in this subarray
            return 0;
        if (j == i) // one element in this subarray
            return freq[i];
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        // Get sum of freq[i], freq[i+1], ... freq[j]
        int sum = fsum(freq, i, j);
        // Initialize minimum value
        int min = Integer.MAX_VALUE;
        for (int r = i; r <= j; ++r) {
            min = Math.min(optCost(freq, i, r - 1) + optCost(freq, r + 1, j), min);
        }
        // Return minimum value
        return dp[i][j] = min + sum;
    }

    static int optimalSearchTree(int keys[], int freq[], int n) {
        dp = new int[n][n];
        return optCost(freq, 0, n - 1);
    }

    // A utility function to get sum of array elements freq[i] to freq[j]
    static int fsum(int freq[], int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++)
            s += freq[k];
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int keys[] = new int[n];
        int freq[] = new int[n];
        for (int i = 0; i < n; i++)
            keys[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            freq[i] = sc.nextInt();
        System.out.println("Cost of Optimal BST is " + optimalSearchTree(keys, freq, n));
        sc.close();
    }
}