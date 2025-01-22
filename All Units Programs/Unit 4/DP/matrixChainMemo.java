import java.util.*;

/*
 * T(n)=O(n^3)
 */

class MatrixChainMultiplicationMemoised {
    static int[][] dp;

    static int matrixChainMemoised(int p[], int i, int j) {
        if (i == j)
            return 0;
        if (dp[i][j] != 0)
            return dp[i][j];
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            dp[i][j] = Math.min(dp[i][j], matrixChainMemoised(p, i, k) +
                    matrixChainMemoised(p, k + 1, j) + p[i - 1] * p[k] * p[j]);
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[i][j];
    }

    static int MatrixChainOrder(int[] p, int n) {
        dp = new int[n][n];
        return matrixChainMemoised(p, 1, n - 1);
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(MatrixChainOrder(arr, n));
        sc.close();
    }
}