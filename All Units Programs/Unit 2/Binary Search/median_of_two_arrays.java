import java.io.*;
import java.util.*;

/*
 * O(log min(n,m))
 */
public class median_of_two_arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr2[] = new int[m];
        int arr1[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i< m ; i++){
            arr2[i] = sc.nextInt();
        }
        double median = medianOfSortedArr(arr1 , arr2);
        PrintStream printr = new PrintStream(System.out); 
        printr.println(median);
        sc.close();
    }
    private static double medianOfSortedArr(int arr1 [] , int arr2[]){
        if(arr1.length > arr2.length){
            int temp [] = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        int x = arr1.length;
        int y = arr2.length;

        int low = 0;
        int high = x;
        while (low<=high) {
            int midX = (low+high)/2;
            int midY = (x+y+1)/2 - midX;

            int maxLeftX = (midX==0)? Integer.MIN_VALUE : arr1[midX-1];
            int minRightX = (midX==arr1.length)?Integer.MAX_VALUE : arr1[midX];
            int maxLeftY = (midY==0)? Integer.MIN_VALUE : arr2[midY-1];
            int minRightY = (midY==arr2.length)?Integer.MAX_VALUE : arr2[midY];

            if ((maxLeftX<minRightY)&&(maxLeftY<minRightX)) {
                if((x+y)%2==0){
                    return ((double)(Math.max(maxLeftX, maxLeftY)+Math.min(minRightX, minRightY))/2);
                }
                else{
                    return (double)(Math.max(maxLeftX, maxLeftY));
                }
            }
            else if(maxLeftY>minRightX){
                low = midX+1;
            }
            else if (maxLeftX>minRightY){
                high = midX-1;
            }

        }
        return 0;
    }
}