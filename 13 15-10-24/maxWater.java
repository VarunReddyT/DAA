// You are given an array height that represents the height of a series of vertical pillars standing on a flat surface. 
// The pillars are located at indices (i, 0) and extend vertically to the height height[i]. 
// The task is to find two pillars that can form a container with the x-axis (ground) that can store the maximum amount of water between them.

// Your goal is to maximize the water held between any two pillars, taking into consideration the height of the shorter pillar and the distance between them.

// Input Format:
// -------------
// Line-1: An integer n, representing the number of pillars.
// Line-2: n space-separated integers representing the heights of the pillars.

// Output Format:
// --------------
// Line-1: Print an integer representing the maximum amount of water that the container formed by two pillars can store.

// Constraints:
// ------------
// 2 <= n <= 10^5
// 0 <= height[i] <= 10^4

// Sample Input-1:
// ---------------
// 9
// 1 8 6 2 5 4 8 3 7

// Sample Output-1:
// ----------------
// 49

// Explanation:
// The best choice is the pillar at index 1 (height 8) and the pillar at index 8 (height 7). The distance between them is 7, and the minimum height is 7, thus the water stored is 7 * 7 = 49.


// Sample Input-2:
// ---------------
// 2
// 1 1

// Sample Output-2:
// ----------------
// 1

// Explanation:
// The only two pillars are at index 0 and index 1, both with height 1. The distance between them is 1, so the water stored is 1 * 1 = 1.

import java.util.*;

public class maxWater{
    public static int getWater(int[] arr, int n){
        int left = 0;
        int right = n-1;
        int area = 0;
        while(left<right){
            int length = right-left;
            area = Math.max(area,Math.min(arr[left],arr[right])*length);
            
            if(arr[left] < arr[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return area;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(getWater(arr,n));
        sc.close();
    }
}