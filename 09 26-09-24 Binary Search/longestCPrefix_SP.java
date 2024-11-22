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
public class longestCPrefix_SP{
    private static String smallestString(String[] arr ){
        String smallest = arr[0];
        for(int i = 1; i<arr.length;i++){
            if(arr[i].length() < smallest.length()){
                smallest = arr[i];
            }
        }
        return smallest;
    }
    private static String commonPref(String [] arr){  
        String small = smallestString(arr);
        String result = "";
        int low = 0;
        int high = small.length()-1;
        while (low<=high) {
            int mid = (low+high)/2;
            if(isCommon(arr, mid,small)){
                result = small.substring(0,mid+1);
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return result;
    }
    private static boolean isCommon(String [] arr, int mid,String small){
        String pre = small.substring(0,mid+1);
        for (int i = 0; i < arr.length; i++) {
            if(!arr[i].startsWith(pre)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
        Scanner sc  = new Scanner(System.in);
        String arr[] = sc.nextLine().split(" ");
        String small  = commonPref(arr);
        System.out.println(small);

        sc.close();

    }
}