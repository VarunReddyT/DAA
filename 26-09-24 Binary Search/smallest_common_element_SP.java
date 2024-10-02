// You are given an m x n matrix mat where each row is sorted in non-decreasing order.

// Your task is to find the smallest common element in all rows. If there is no common element, return -1.

// Input Format:
// --------------
// Line-1: Two integers m and n, representing the number of rows and columns, respectively.
// Line-2: The next m lines contain n space-separated integers each, representing the elements of the matrix. Each row of the matrix is sorted in non-decreasing order.

// Output Format:
// ---------------
// Line-1: Print a single integer, the smallest common element in all rows. If no common element exists, print -1.

// Constraints:
// -------------
// 1 ≤ m, n ≤ 500
// 1 ≤ mat[i][j] ≤ 10^4
// Each row is sorted in non-decreasing order.

// Sample Input-1:
// ----------------
// 3 4
// 1 2 3 4
// 2 3 5 7
// 3 5 6 7

// Sample Output-1:
// -----------------
// 3

// Explanation: The number 3 is the smallest common element in all rows.


// Sample Input-2:
// ---------------
// 2 3
// 1 2 3
// 4 5 6

// Sample Output-2:
// ----------------
// -1

// Explanation: There is no common element in all rows, so the output is -1.
import java.util.*;
public class smallest_common_element_SP{

    public static int binarySearch(int[] arr, int target, int low, int high){
        int left = low;
        int right = high;
        int mid;
        while(left<=right){
            mid = (right+left)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid]>target){
                right = mid-1;
            }
            else{
                left = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int mat[][] = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                mat[i][j] = sc.nextInt();
            }
        }

        boolean flag = false;
        for(int i = 0;i<m;i++){
            int count = 0;
            for(int j = 1;j<n;j++){
                if(binarySearch(mat[j],mat[0][i],0,m-1)!=-1){
                    count++;
                }
            }
            if(count == n-1){
                System.out.println(mat[0][i]);
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println(-1);
        }

        sc.close();
    }
}
