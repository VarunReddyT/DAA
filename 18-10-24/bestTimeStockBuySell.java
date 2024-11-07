import java.util.*;

public class bestTimeStockBuySell{
    public static int calculateProfit(String[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0;i<prices.length;i++){
            minPrice = Math.min(minPrice,Integer.parseInt(prices[i]));
            maxProfit = Math.max(maxProfit,Integer.parseInt(prices[i])-minPrice);
        }
        return maxProfit;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String[] prices = sc.nextLine().split(" ");
        
        System.out.println(calculateProfit(prices));
        sc.close();
    }
}
