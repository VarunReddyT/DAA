import java.util.*;

public class QuickSortRecursion {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition_low(int arr[], int low, int high) {
        int pivot = arr[low];
        int k = high;
        for (int i = high; i > low; i--) {
            if (arr[i] > pivot) {
                swap(arr, i, k);
                k--;
            }
        }
        swap(arr, low, k);
        return k;
    }

    // routine to sort the array partitions recursively
    void quick_sort(int intArray[], int low, int high) {
        if (low < high) {
            int pi = partition_low(intArray, low, high);

            quick_sort(intArray, low, pi - 1);
            quick_sort(intArray, pi + 1, high);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter array size");
        int n = sc.nextInt();
        int a[] = new int[n];

        System.out.println("enter the elements of array ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Original Array: " + Arrays.toString(a));

        QuickSortRecursion obj = new QuickSortRecursion();

        obj.quick_sort(a, 0, n - 1);

        System.out.println("Sorted Array: " + Arrays.toString(a));
        sc.close();
    }
}