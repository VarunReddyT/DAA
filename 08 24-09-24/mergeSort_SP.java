// You are given an unsorted array of integers. 
// Your task is to implement the MergeSort algorithm to sort the array in ascending order.

// MergeSort is a divide-and-conquer algorithm that:
// 	-Divides the array into two halves.
// 	-Recursively sorts the two halves.
// 	-Merges the two sorted halves to produce the final sorted array.
// 	-Your task is to write a function that sorts the given array using MergeSort.

// Input Format:
// --------------
// Line-1: An integer n (the size of the array).
// Line-2: n space-separated integers representing the elements of the array.

// Output Format:
// ---------------
// Line-1: Output the sorted array in a single line, with each element separated by a space.

// Constraints:
// ------------
// 1 ≤ n ≤ 10^5
// -10^9 ≤ arr[i] ≤ 10^9


// Sample Input-1:
// ---------------
// 6
// 12 11 13 5 6 7

// Sample Output-1:
// ----------------
// 5 6 7 11 12 13


// Sample Input-2:
// ---------------
// 5
// 10 1 2 8 5

// Sample Output-2:
// ----------------
// 1 2 5 8 10

import java.util.*;
public class mergeSort_SP{

    public static void merge(int[] arr, int low, int high){
        int mid = (low+high)/2;
        int i = 0, j = 0, k = low;
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for(i = 0;i<n1;i++){
            left[i] = arr[low+i];
        }
        for(j = 0;j<n2;j++){
            right[j] = arr[mid+1+j];
        }
        i = 0;
        j = 0;
        while(i<n1 && j<n2){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = right[j];
            j++;
            k++;
        }

    }
    public static void merge_sort(int[] arr,int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            merge_sort(arr,low,mid);
            merge_sort(arr,mid+1,high);
            merge(arr,low,high);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        merge_sort(arr,0,n-1);
        for(int i = 0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
