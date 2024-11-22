// You are given n items, each with a specific weight and value. 
// You are also given a knapsack that can hold a maximum weight W. 
// The goal is to maximize the total value in the knapsack by selecting items to add.

// NOTE: You can take fractions of items instead of having to take the whole item. 
// You need to calculate the maximum possible value that can be achieved.

// Input Format:
// -------------
// Line-1: Two integers n and W representing the number of items and the maximum weight capacity of the knapsack, respectively.
// Line-2 to n: Each line contains two integers value and weight for each item.

// Output Format:
// --------------
// Line-1: Printing the maximum total value that can be obtained in the knapsack, rounded to two decimal places.

// Constraints:
// -------------
// 1 <= n <= 10^5
// 0 <= W <= 10^9
// 1 <= value, weight <= 10^9

// Sample Input-1:
// ---------------
// 3 50
// 60 10
// 100 20
// 120 30

// Sample Output-1:
// ----------------
// 240.00

// Explanation:
// ------------
// The first item can be added in full (value = 60, weight = 10).
// The second item can be added in full (value = 100, weight = 20).
// The third item can be added partially, using only 20 out of 30 weight capacity, which gives a value of (120/30) * 20 = 80.
// Thus, the total value is 60 + 100 + 80 = 240.

// Sample Input-2:
// ---------------
// 2 50
// 60 20
// 100 50

// Sample Output-2:
// ----------------
// 160.00

// Explanation:
// ------------
// The first item can be added in full (value = 60, weight = 20).
// From the second item, only 30 weight units can be used, so the value will be (100/50) * 30 = 60.
// Thus, the total value is 60 + 60 = 160.

// Sample Input-3:
// ---------------
// 1 10
// 500 30

// Sample Output-3:
// ----------------
// 166.67

// Explanation:
// ------------
// The item has a value of 500 and a weight of 30. Since the knapsack can only hold 10 units of weight, we take a fraction of the item.
// The value of 10 units from the first item is (500/30) * 10 = 166.67.
// Thus, the total value is 166.67

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
public class knapSack{
    
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

