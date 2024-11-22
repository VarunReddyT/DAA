// Given an array nums of size n, return the majority element. 
// The majority element is the element that appears more than ⌊n / 2⌋ times.

// You may assume that the majority element always exists in the array.

// Input Format:
// --------------
// Line-1: An integer n (the size of the array).
// Line-2: n space-separated integers representing the elements of the array.

// Output Format:
// --------------
// Line-1: Output a single integer, the majority element.

// Constraints:
// -------------
// 1 ≤ n ≤ 5 * 10^4
// -10^9 ≤ nums[i] ≤ 10^9


// Sample Input-1:
// ---------------
// 3
// 3 2 3

// Sample Output-1:
// ----------------
// 3

// Explanation:
// The number 3 appears more than n/2 times, so it is the majority element.

// Sample Input-2:
// ---------------
// 7
// 2 2 1 1 1 2 2

// Sample Output-2:
// ----------------
// 2

// Explanation:
// The number 2 appears 4 times, which is more than n/2 = 3.5, so it is the majority element.

import java.util.*;
public class majority_element_SP {
    public static void main(String[] args) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        int[] arr = {3,2,3,2,1,3,3,3};
        int n = 8;
        int half = n/2;
        for(int i : arr){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            if(entry.getValue() >= half){
                System.out.println(entry.getKey());
                break;
            }
        }
    }
}
