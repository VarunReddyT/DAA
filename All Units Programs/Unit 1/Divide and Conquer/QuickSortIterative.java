import java.util.*;

public class QuickSortIterative {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int k = end;

        for (int i = end; i> start; i--) {
            if (arr[i] > pivot) {
                swap(arr, i, k);
                k--;
            }
        }

        swap(arr, start, k);
        return k;
    }

    public static void iterativeQuicksort(int[] arr) {
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[] { 0, arr.length - 1 });

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            int start = range[0];
            int end = range[1];

            if (start < end) {
                int pivot = partition(arr, start, end);

                // Push left and right subarrays into the stack
                stack.push(new int[] { start, pivot - 1 });
                stack.push(new int[] { pivot + 1, end });
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array: " + Arrays.toString(arr));

        iterativeQuicksort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
        sc.close();
    }
}
