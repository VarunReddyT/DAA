import java.util.*;
public class longestCPrefix_SP{
    private static String smallestString(String[] arr ){
        String smallest = arr[0];
        for(int i = 1; i<arr.length;i++){
            if(arr[i].length() < smallest.length()){
                smallest = arr[i];
            }
        }
        return smallest;
    }
    private static String commonPref(String [] arr){  
        String small = smallestString(arr);
        String result = "";
        int low = 0;
        int high = small.length()-1;
        while (low<=high) {
            int mid = (low+high)/2;
            if(isCommon(arr, mid,small)){
                result = small.substring(0,mid+1);
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return result;
    }
    private static boolean isCommon(String [] arr, int mid,String small){
        String pre = small.substring(0,mid+1);
        for (int i = 0; i < arr.length; i++) {
            if(!arr[i].startsWith(pre)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
        Scanner sc  = new Scanner(System.in);
        String arr[] = sc.nextLine().split(" ");
        String small  = commonPref(arr);
        System.out.println(small);

        sc.close();

    }
}