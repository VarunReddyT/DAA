import java.util.*;

/*
 * O(nlogn)
 * BS + sorting
 */
public class fixed_point {
    public int fixedPoint(int[] arr, int low, int high) {
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

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        // Printing the array after sorting
        System.out.println("sorted array[]:" + Arrays.toString(arr));
        System.out.println(new fixed_point().fixedPoint(arr,0,n-1));
        sc.close();
    }
}