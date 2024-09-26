import java.util.*;

public class binarySearch {
    public static int search(int[] arr, int target,int low,int high){
        int left = low;
        int right = high;
        int mid;
        while(left<=right){
            mid = (right+left)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid]>target){
                right = mid;
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
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int index = search(arr, target,0,arr.length-1);

        if(index == -1){
            System.out.println("Element not found");
        }
        else{
            System.out.println("Element found at index : " + index);
        }

        sc.close();
    }
}
