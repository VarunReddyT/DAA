// You are given an m x n matrix of integers where:
// 	*Each row is sorted in non-decreasing order.
// 	*The first integer of each row is greater than the last integer of the previous row.

// Given an integer target, your task is to determine if the target exists in the matrix. If it does, return the row and column indices where it is found. If it does not exist in the matrix, return -1.

// You must implement the solution with a time complexity of O(log(m * n)) using a binary search approach.

// Input Format:
// -------------
// Line-1: Two integers m and n, representing the number of rows and columns in the matrix.
// Line-2 to m: The next m lines each contain n integers, representing the matrix elements.
// Line m+1: The last line contains the integer k, the target value to search for in the matrix.

// Output Format:
// ---------------
// If the target exists, print the row and column indices of the target in the matrix.
// If the target does not exist, print -1.

// Constraints:
// -------------
// 1 ≤ m, n ≤ 1000
// -10^4 ≤ matrix[i][j], k ≤ 10^4

// Sample Input-1:
// ---------------
// 3 4
// 1 3 5 7
// 10 11 16 20
// 23 30 34 60
// 3

// Sample Output-1:
// ----------------
// 0 1

// Explanation:
// The target 3 is found in row 0 and column 1.


// Sample Input-2:
// ---------------
// 3 4
// 1 3 5 7
// 10 11 16 20
// 23 30 34 60
// 13

// Sample Output-2:
// ----------------
// -1

// Explanation:
// The target 13 does not exist in the matrix, so the output is -1.

import java.util.*;

public class search_sorted_matrix_AP{
    public static int binarySearchEnd(int[][] arr, int target){
        int left = 0;
        int right = arr.length-1;
        int rowSize = arr[0].length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid][rowSize] == target){
                return mid;
            }
            else if(arr[mid][rowSize] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        if(left<arr.length && arr[left][rowSize] >= target){
            return left;
        }
        else{
            return -1;
        }
    }
    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        int row = binarySearchEnd(matrix,k);
        if(row == -1){
            System.out.println(row);
        }
        else{
            int col = binarySearch(matrix[row],k);
            if(col == -1){
                System.out.println(col);
            }
            else{
                System.out.println(row + " " + binarySearch(matrix[row],k));
            }
        }
        sc.close();
    }
}