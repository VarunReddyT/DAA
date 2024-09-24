
public class mergeSort{

    public static void merge(int[] arr, int low, int high){
        int mid = (low+high)/2;
        int i = 0, j = 0, k = low;
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for(i = 0;i<n1;i++){
            left[i] = arr[low+i];
        }
        for(j = 0;j<n2;j++){
            right[j] = arr[mid+1+j];
        }
        i = 0;
        j = 0;
        while(i<n1 && j<n2){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = right[j];
            j++;
            k++;
        }

    }
    public static void merge_sort(int[] arr,int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            merge_sort(arr,low,mid);
            merge_sort(arr,mid+1,high);
            merge(arr,low,high);
        }
    }
    public static void main(String[] args){
        int[] arr = {34,2,542,2,4,56,8};
        int n = 7;
        merge_sort(arr,0,n-1);
        for(int i = 0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
