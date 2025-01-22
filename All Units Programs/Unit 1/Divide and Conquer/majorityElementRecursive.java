import java.util.*;

/*
 * At each level of recursion:
 *   The array is divided into two parts.
 *  Two recursive calls are made.
 *  The count function runs in 𝑂(𝑛)
 * T(n)=2T(n/2)+O(n)
 
 * T(n)=O(nlogn)
 * 
 */
public class majorityElementRecursive{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(majorityElement(arr, 0, arr.length - 1));
        sc.close();
    }

    private static int count(int arr[], int low, int high, int target) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            count += (arr[i] == target) ? 1 : 0;
        }
        return count;
    }

    private static int majorityElement(int arr[], int low, int high) {
        if (low == high) {
            return arr[low];
        }
        int mid = (low + high) / 2;
        int left = majorityElement(arr, low, mid);
        int right = majorityElement(arr, mid + 1, high);
        if (left == right) {
            return left;
        }
        int leftCount = count(arr, low, high, left);
        int rightCount = count(arr, low, high, right);
        return (leftCount > rightCount) ? left : right;
    }
}