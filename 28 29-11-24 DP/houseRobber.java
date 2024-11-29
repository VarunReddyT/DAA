// A group of houses is arranged in a street, and each house has a certain amount of money stashed inside. 
// A robber wants to steal the maximum amount of money possible. 
// However, there is a catch: 
// "the robber cannot rob two adjacent houses as it will alert the police."

// You are tasked to calculate the maximum amount of money the robber can steal without alerting the police.

// Input Format:
// -------------
// Line-1: An integer n, representing the number of houses in the street.
// Line-2: n space-separated integers, representing the money stashed in each house.
  
// Output Format:
// --------------
// Line-1: An integer, Print the maximum amount of money the robber can steal without alerting the police.


// Sample Input-1:
// ---------------
// 5
// 100 50 400 200 100
  
// Sample Output-1:
// ----------------
// 600

// Explanation:
// ------------
// The robber will steal 100, 400 and 100 from the houses.
// Refer Hint for more.
   
// Sample Input-2:
// ---------------
// 5
// 5 3 4 11 2 
  
// Sample Output-2:
// ----------------
// 16

// Explanation:
// ------------
// Thief will steal 5 and 11 from the houses.

import java.util.*;

public class houseRobber{
    public static int maxMoney(int[] houses, int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return houses[0];
        }
        if(n==2){
            return Math.max(houses[0],houses[1]);
        }
        int[] dp = new int[n];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0],houses[1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+houses[i]);
        }
        return dp[n-1];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] houses = new int[n];
        for(int i=0;i<n;i++){
            houses[i] = sc.nextInt();
        }
        System.out.println(maxMoney(houses,n));
        sc.close();
    }
}