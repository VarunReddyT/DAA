import java.util.*;

public class pair_difference{
    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                right = mid-1;
            }
            else{
                left = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int k = sc.nextInt();
        for(int i = 0;i<n;i++){
            int p = k+arr[i];
            if(p>arr[n-1]){
                break;
            }
            int index = binarySearch(arr,p);
            if(index != -1){
                System.out.println(arr[i] + " " + arr[index]);
            }            
        }
        
        sc.close();
    }

}
