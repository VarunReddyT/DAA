// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements. 
// The operation should be performed in-place without making a copy of the array, and the time complexity should be minimized.

// Constraints:
// ------------
// nums contains only integers.
// You must maintain the relative order of the non-zero elements.
// The operation must be done in-place with O(1) extra space.

// Input Format:
// -------------
// Line-1: An integer, size of the array
// Line-2 to n: A single array of integers nums with at least one element.

// Output Format:
// -------------
// Line-1: The modified input array nums, where all zeros are moved to the end while maintaining the relative order of the non-zero elements.

// Sample Input-1:
// ----------------
// 5
// 0 1 0 3 12

// Sample Output-1:
// ----------------
// 1 3 12 0 0

// Sample Input-2:
// ---------------
// 1
// 0

// Sample Output-2:
// -----------------
// 0

import java.util.*;

public class Move2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int index = 0;
        int temp;
        for(int i = 0;i<n;i++){
            if(arr[i] != 0){
                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                index++;
            }
        }
        for(int i = 0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
