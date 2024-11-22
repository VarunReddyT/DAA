// You are given an array of distinct integers sorted in increasing order. 
// A fixed point in an array is an index i such that arr[i] == i.

// Return the smallest index that satisfies arr[i] == i. 
// If there is no such index, return -1.

// Input Format:
// -------------
// Line-1: An integer n, the number of elements in the array.
// Line-2: n space-separated integers, representing the elements of the array.

// Output Format:
// --------------
// Line-1: Return a single integer, which is the smallest index i such that arr[i] == i. If no such index exists, return -1.

// Constraints:
// -------------
// 1 ≤ n ≤ 10^4
// -10^4 ≤ arr[i] ≤ 10^4
// The array arr is sorted in strictly increasing order (i.e., no duplicates).


// Sample Input-1:
// ----------------
// 5
// -10 -5 0 3 7

// Sample Output-1:
// -----------------
// 3

// Explanation: For the array arr = [-10, -5, 0, 3, 7], the index 3 satisfies arr[3] == 3.


// Sample Input-2:
// ---------------
// 4
// 0 2 5 8

// Sample Output-2:
// ----------------
// 0

// Explanation: For the array arr = [0, 2, 5, 8], the index 0 satisfies arr[0] == 0.


// Sample Input-3:
// ----------------
// 6
// -10 -5 1 3 6 7

// Sample Output-3:
// -----------------
// -1

// Explanation: No index i satisfies arr[i] == i.
import java.util.*;
public class fixedPoint_SP {
    public static int fixedp(int[] arr, int low, int high){
        int left = low;
        int right = high;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid] - mid >= 0){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return arr[left]==left ? left : -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int fp = fixedp(arr,0,n-1);

        System.out.println(fp);

        sc.close();
    }
}
