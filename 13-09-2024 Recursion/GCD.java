// Given an integer array nums, return the greatest common divisor (GCD) of the smallest number and the largest number in the array.

// The Greatest Common Divisor (GCD) of two numbers is the largest positive integer that divides both numbers without leaving a remainder.

// Constraints:
// -------------
// 2 ≤ nums.length ≤ 1000
// 1 ≤ nums[i] ≤ 1000

// Input Format:
// -------------
// Line-1: An integer, represents size of array
// Line-2: A single integer array nums of length between 2 and 1000, where each element is a positive integer ans space separated.

// Output Format:
// --------------
// Line-2: Return the GCD of the smallest and largest numbers in the array.

// Sample Input-1:
// --------------- 
// 2 5 6 9 10

// Sample Output-1: 
// -----------------
// 2

// Explanation:
// The smallest number is 2 and the largest number is 10.
// The GCD of 2 and 10 is 2.


// Sample Input-2: 
// ---------------
// 7, 5, 6, 8, 3

// Sample Output-2: 
// ----------------
// 1

// Explanation:
// The smallest number is 3 and the largest number is 8.
// The GCD of 3 and 8 is 1.

import java.util.*;

public class GCD{
    static public int gcd(int minNum, int maxNum){
        if(maxNum == 0){
            return minNum;
        }
        return gcd(maxNum,minNum%maxNum);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int minNum = arr[0];
        int maxNum = arr[n-1];
        System.out.println(gcd(minNum,maxNum));
        sc.close();
    }
}