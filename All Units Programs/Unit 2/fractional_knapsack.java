import java.util.*;

class ItemValue implements Comparable<ItemValue>{
    int value, weight;
    ItemValue(int value, int weight){
        this.value = value;
        this.weight = weight;
    }
    public int getValue(){
        return value;
    }
    public int getWeight(){
        return weight;
    }
    @Override
    public int compareTo(ItemValue v1){
        double ratio = (double)this.value/this.weight;
        double ratio2 = (double)v1.value/v1.weight;
        return Double.compare(ratio2, ratio);
    }
    @Override
    public String toString(){
        String s = getValue() + " " + getWeight();
        return s;
    }
}
public class fractional_knapsack{
    
    public static double getMaxItems(int curr_cap, int max_cap, double res, ArrayList<ItemValue> arr){
        Collections.sort(arr);
        
        for(ItemValue item : arr){
            if(curr_cap - item.getWeight() >= 0){
                curr_cap -= item.getWeight();
                res += item.getValue();
            }
            else{
                res += item.getValue() * ((double) curr_cap / item.getWeight());
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {

        ArrayList<ItemValue> arr = new ArrayList<>();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max_cap = sc.nextInt();
        
        for(int i = 0;i<n;i++){
            arr.add(new ItemValue(sc.nextInt(),sc.nextInt()));
        }
        
        System.out.println(getMaxItems(max_cap,max_cap,0,arr));

        sc.close();
    }
}

