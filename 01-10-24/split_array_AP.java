// You are given an integer array nums and an integer k. 
// Your task is to split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

// A subarray is a contiguous part of the array. You need to return the minimized largest sum of the split.

// Input Format:
// --------------
// Line-1: Integers representing the elements of the array nums, separated by commas.
// Line-2: An integer k, representing the number of subarrays to split nums into.

// Output Format:
// ---------------
// Line-1: Print a single integer representing the minimized largest sum after splitting the array into k subarrays.

// Constraints:
// -------------
// 1 ≤ nums.length ≤ 1000
// 0 ≤ nums[i] ≤ 10^6
// 1 ≤ k ≤ min(50, nums.length)

// Sample Input-1:
// ---------------
// 7,2,5,10,8
// 2

// Sample Output-1:
// ----------------
// 18

// Explanation:
// There are four ways to split nums into two subarrays. The best way is to split it into [7, 2, 5] and [10, 8], where the largest sum among the two subarrays is only 18.


// Sample Input-2:
// ---------------
// 1,2,3,4,5
// 2

// Sample Output-2:
// ----------------
// 9

// Explanation:
// The best way to split nums into two subarrays is [1, 2, 3] and [4, 5], where the largest sum is 9.

import java.util.*;

public class split_array_AP{
    public static boolean splitArray(int[] arr, int mid, int k){
        int count = 1;
        int sum = 0;
        for(int i : arr){
            if(sum + i > mid){
                count++;
                sum = i;
                if(count > k){
                    return false;
                }
            }
            else{
                sum += i;
            }
        }
        return true;
    }
    public static int binarySearch(int[] arr, int k){
        int left = arr[0];
        int right = 0;
        for(int i : arr){
            left = Math.max(left,i);
            right += i; 
        }
        while(left<=right){
            int mid = (left+right)/2;
            if(splitArray(arr,mid,k)){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] array = s.split(",");
        int[] arr = new int[array.length];
        for(int i = 0;i<array.length;i++){
            arr[i] = Integer.parseInt(array[i]);
        }
        int k = sc.nextInt();
        System.out.println(binarySearch(arr,k));
        sc.close();
    }
}