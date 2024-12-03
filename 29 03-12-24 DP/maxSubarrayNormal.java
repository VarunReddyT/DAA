import java.util.*;
public class maxSubarrayNormal{
    public static int maxSubarray(int[] arr, int n){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum += arr[i];
            max = Math.max(sum,max);
            if(sum<0){
                sum = 0;
            }
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