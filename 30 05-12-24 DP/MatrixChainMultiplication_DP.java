import java.util.*;
public class MatrixChainMultiplication_DP {
    public static int matrixChainMultiplication(int[] arr, int i, int j, int[][] dp){
        if(i==j){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
            dp[i][j] = Math.min(dp[i][j],matrixChainMultiplication(arr, i, k, dp)+matrixChainMultiplication(arr, k+1, j, dp) + arr[i-1]*arr[k]*arr[j]);
        }
        return dp[i][j];
    }
    public static int matrixChainOrder(int[] arr, int i, int n){
        int[][] dp = new int[n][n];
        return matrixChainMultiplication(arr,i,n-1,dp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(matrixChainOrder(arr,1,n));
        sc.close();

    }
}
