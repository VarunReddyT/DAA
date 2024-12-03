import java.util.*;

public class maxSubarrayDP {
    public static int maxSubarray(int[] arr, int n){
        int[] dp = new int[n];
        dp[0] = arr[0];
        int max = dp[0];
        for(int i = 1;i<n;i++){
            dp[i] = arr[i] + (dp[i-1]>0 ? dp[i-1] : 0);
            max = Math.max(dp[i],max);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maxSubarray(arr, n));
        sc.close();
    }
}
