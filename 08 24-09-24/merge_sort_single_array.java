import java.util.*;

public class merge_sort_single_array {
    public static void merge(int[] arr, int low, int mid,int high){
        int i = low;
        int j = mid+1;
        int k = 0;

        int[] res = new int[high-low+1];
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                res[k] = arr[i];
                i++;
            } 
            else {
                res[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            res[k] = arr[i];
            i++;
            k++;
        }
        while(j<=high){
            res[k] = arr[j];
            j++;
            k++;
        }
        for(int p = 0;p<res.length;p++){
            arr[low+p] = res[p];
        }
    }
    public static void merge_sort(int[] arr, int low, int high){
        if(low<high){
            int mid = (low+high)/2;
            merge_sort(arr,low,mid);
            merge_sort(arr,mid+1,high);
            merge(arr,low,mid,high);
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
