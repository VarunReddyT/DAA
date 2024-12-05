import java.util.*;
public class MatrixChainMultiplication_Memoization {
    public static int matrixChainMultiplication(int[] arr,int n, int[][] dp){
        for(int len = 1; len<n-1;len++){
            for(int i = 1; i<n-len;i++){
                int j = i+len;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i;k<j;k++){
                    int cost = dp[i][k] + dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
                    dp[i][j] = Math.min(dp[i][j],cost);
                }
            }
        }
        return dp[1][n-1];
    }
    public static int matrixChainOrder(int[] arr, int n){
        int[][] dp = new int[n][n];
        return matrixChainMultiplication(arr,n,dp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(matrixChainOrder(arr,n));
        sc.close();

    }
}
