package DP;
import java.util.*;

class MatrixChainMultiplicationDP {
    static int MatrixChainOrder(int p[], int n) {
        int dp[][] = new int[n][n];
        int i, j, k, len, cost;
        for (len = 2; len < n; len++) {
            for (i = 1; i <= n - len; i++) {
                j = i + len - 1;
                if (j == n)
                    continue;
                dp[i][j] = Integer.MAX_VALUE;
                for (k = i; k < j; k++) {
                    cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    System.out.println("i " + i + " k " + k + " j " + j + " len "
                            + len + " cost " + cost);
                    if (cost < dp[i][j])
                        dp[i][j] = cost;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[1][n - 1];
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