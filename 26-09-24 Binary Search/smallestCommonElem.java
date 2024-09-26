import java.util.*;
public class smallestCommonElem {

    public static int binarySearch(int[] arr, int target, int low, int high){
        int left = low;
        int right = high;
        int mid;
        while(left<=right){
            mid = (right+left)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid]>target){
                right = mid-1;
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
        int m = sc.nextInt();
        int mat[][] = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                mat[i][j] = sc.nextInt();
            }
        }

        for(int i = 0;i<m;i++){
            int count = 0;
            for(int j = 1;j<n;j++){
                if(binarySearch(mat[j],mat[0][i],0,m-1)!=-1){
                    count++;
                }
            }
            if(count == n-1){
                System.out.println("Most Common Element : " + mat[0][i]);
                break;
            }
        }

        sc.close();
    }
}
