import java.util.*;
public class fixedPoint {
    public static int fixedp(int[] arr, int low, int high){
        int index = -1;
        int left = low;
        int right = high;
        while(left<right){
            int mid = (left+right)/2;
            if(arr[mid] - mid == 0){
                index = mid;
                right = mid - 1;
            }
            else if(arr[mid] - mid > 0){
                right = mid-1;
            }
            else{
                left = mid + 1;
            }
        }
        return arr[left]==left ? left : index;
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
