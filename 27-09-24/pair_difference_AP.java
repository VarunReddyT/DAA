// Mr. Ram works in a manufacturing industry where items of different weights are produced. 
// His task is to find pairs of items whose weight difference is equal to a given value k. 
// You are asked to write a program to help Mr. Ram achieve this without using extra space.

// Input Format:
// -------------
// Line-1: An integer n, the number of items (weights).
// Line-2: n space-separated positive integers representing the weights of the items.
// Line3: An integer k, the desired difference between the weights of the paired items.

// Output Format:
// --------------
// Line-1 to n: Print the pairs of integers where the difference between the two numbers in each pair is exactly k.
// Each pair should be printed on a new line.

// Constraints:
// ------------
// The input list will contain distinct integers.
// You are not allowed to use extra space, so you must solve the problem in-place or by using a fixed amount of space.


// Sample Input-1:
// ---------------
// 8
// 1 2 3 4 5 6 7 8
// 3

// Sample Output-1:
// ----------------
// 1 4
// 2 5
// 3 6
// 4 7
// 5 8

// Sample Input-2:
// ---------------
// 10
// 5 10 15 20 25 30 35 40 45 50
// 5

// Sample Output-2:
// ----------------
// 5 10
// 10 15
// 15 20
// 20 25
// 25 30
// 30 35
// 35 40
// 40 45
// 45 50


import java.util.*;

public class pair_difference_AP{
    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                right = mid-1;
            }
            else{
                left = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int k = sc.nextInt();
        for(int i = 0;i<n;i++){
            int p = k+arr[i];
            if(p>arr[n-1]){
                break;
            }
            int index = binarySearch(arr,p);
            if(index != -1){
                System.out.println(arr[i] + " " + arr[index]);
            }            
        }
        
        sc.close();
    }

}
