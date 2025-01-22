import java.util.*;
public class koko_eating_bananas{
    public static int binarySearch(int[] arr, int hours){
        int left = 1;
        int right = 1;
        for(int i : arr){
            right = Math.max(right,i);
        }
        while(left<=right){
            int hoursSpent = 0;
            int mid = (left+right)/2;
            for(int i : arr){
                hoursSpent += Math.ceil((double)i/mid);
            }
            if(hoursSpent <= hours){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(binarySearch(arr,h));
        sc.close();
    }
}