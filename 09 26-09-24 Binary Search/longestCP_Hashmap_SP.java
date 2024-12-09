// Given an array of strings strs, find the longest common prefix among all strings.

// If there is no common prefix, return an empty string "".

// NOTE: Solve Using Binary Search

// Input Format:
// -------------
// Line-1: An integer n, the number of strings in the array.
// Line-2: The next n lines contain n space-separated strings representing the elements of the string array strs.

// Output Format:
// --------------
// Line-1: Print a single string, which is the longest common prefix among all the strings. If no common prefix exists, print an empty string.

// Constraints:
// ------------
// 1 ≤ n ≤ 200
// 0 ≤ strs[i].length ≤ 200
// strs[i] consists of only lowercase English letters.


// Sample Input-1:
// ---------------
// 3
// flower flow flight

// Sample Output-1:
// ----------------
// fl

// Explanation:
// The longest common prefix of the strings flower, flow, and flight is "fl".

// Sample Input-2:
// ---------------
// 3
// dog racecar car

// Sample Output-2:
// ----------------
// ""

// Explanation:
// There is no common prefix among the input strings.

import java.util.*;
public class longestCP_Hashmap_SP{
    private static String smallestString(String[] arr ){
        String smallest = arr[0];
        for(int i = 1; i<arr.length; i++){
            if(arr[i].length() < smallest.length()){
                smallest = arr[i];
            }
        }
        return smallest;
    }

    private static String longestCommonPrefix(String[] arr){
        String smallest = smallestString(arr);
        String result = "";
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < smallest.length(); i++) {
            map.put(smallest.charAt(i), 0);
            for (int j = 0; j < arr.length; j++) {
                map.put(arr[j].charAt(i), map.getOrDefault(arr[j].charAt(i), 0)+1);
            }
            if(map.get(smallest.charAt(i))==arr.length){
                result = result + smallest.charAt(i);
            }
            else{
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String arr[] = sc.nextLine().split(" ");
        String commonPrefix = longestCommonPrefix(arr);
        
        System.out.println(commonPrefix);

        sc.close();

    }
}