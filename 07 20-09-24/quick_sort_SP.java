import java.util.*;

public class quick_sort_SP {
    static int partition_low(int[] arr, int low, int high){
        int pivot = arr[low];
        int k = high;
        for(int i = high;i>=low;i--){
            if(arr[i] > pivot){
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                k--;
            }
        }
        int temp = arr[low];
        arr[low] = arr[k];
        arr[k] = temp;
        return k;
    }

    static int partition_high(int[] arr, int low, int high){
        int pivot = arr[high];
        int k = low;
        for(int i = low;i<high;i++){
            if(arr[i] < pivot){
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                k++;
            }
        }
        int temp = arr[high];
        arr[high] = arr[k];
        arr[k] = temp;
        return k;
    }
    static void quickSort(int[] arr, int low, int high){
        if(low<high){
            int pivotindex = partition_low(arr,low,high);
            // int pivotindex = partition_high(arr,low,high);
            quickSort(arr,low,pivotindex-1);
            quickSort(arr,pivotindex+1,high);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Before Sorting : ");
        for(int i = 0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        quickSort(arr,0,n-1);
        
        System.out.println("After Sorting : ");
        for(int i = 0;i<n;i++){
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
