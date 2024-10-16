// You are given an integer num. Your task is to maximize its value by swapping at most two digits once. 
// Write a program to return the maximum possible value after performing the swap.

// If no swap can increase the value, return the original number.

// Input Format:
// --------------
// Line-1: An integer num, where 0 <= num <= 10^8.

// Output Format:
// --------------
// Line-1: Return an integer representing the maximum value obtained after swapping two digits at most once.

// Sample Input-1:
// ---------------
// 2736

// Sample Output-1:
// ----------------
// 7236

// Explanation:
// ------------
// Swap the digit 2 with 7, resulting in the number 7236, which is the maximum possible value.

// Sample Input-2:
// ---------------
// 9973

// Sample Output-2:
// ----------------
// 9973

// Explanation:
// ------------
// No swap can make the number larger, so return the original number.

import java.util.*;

public class singleDigitPair{

    public static long maxNum(StringBuilder s, long n, int length){
        long max = n;
        for(int i=0; i<length; i++){
            for(int j=i+1; j<length; j++){
                char temp = s.charAt(i);
                s.setCharAt(i, s.charAt(j));
                s.setCharAt(j, temp);
                
                max = Math.max(max,Long.parseLong(s.toString()));
                
                s.setCharAt(j, s.charAt(i));
                s.setCharAt(i, temp);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        String str = Long.toString(n);

        StringBuilder s = new StringBuilder(str);

        System.out.println(maxNum(s, n, str.length()));

        sc.close();
    }
}