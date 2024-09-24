import java.util.*;
public class majority_element {
    public static void main(String[] args) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        int[] arr = {3,2,3,2,1,3,3,3};
        int n = 8;
        int half = n/2;
        for(int i : arr){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            if(entry.getValue() >= half){
                System.out.println(entry.getKey());
                break;
            }
        }
    }
}
