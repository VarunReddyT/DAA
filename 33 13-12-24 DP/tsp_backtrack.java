// Bob Marley is a jamaican singer, he loves to travel around the globe.
// He planned to travel N famous places and return to the starting station.
// Each place is indicated with numbers from 0 to N-1.
// He will start the travel from Place-0.
 
// You are given an integer N and cost matrix cost[][],a symmetric matrix, 
// where cost[i][j] indicates cost to travel from place-i to place-j and vice-versa, 
// if cost[i][j]=0, indicates no way to travel from place-i to place-j and vice-versa. 

// Your task is to help Bob Marley, to find the shortest possible travel plan
// to visit every place and returns to starting place-0. 
// Finally print the minimum cost to travel accordingly.

// Input Format:
// -------------
// Line-1: An integer N. 
// Next N lines: N space separated integers, cost of i to j.

// Output Format:
// --------------
// Print an integer, the minimum cost to travel all the places and return to place-0.


// Sample Input-1:
// ---------------
// 4
// 0 25 10 15
// 25 0 10 45
// 10 10 0 5
// 15 45 5 0

// Sample Output-1:
// ----------------
// 55


// Sample Input-2:
// ---------------
// 5
// 0 15 5 12 15
// 15 0 7 13 9
// 5 7 0 10 15
// 12 13 10 0 7
// 15 9 15 7 0

// Sample Output-2:
// ----------------
// 40

import java.util.*;

public class tsp_backtrack{
    static int res = Integer.MAX_VALUE;
    public static int minCost(int[][] cost, int n){
        boolean[] visited = new boolean[n];
        visited[0] = true;
        helper(cost,n,0,0,0,visited);
        return res;
    }
    public static void helper(int[][] cost, int n, int i, int currCost, int count, boolean[] visited){
        if(count==n-1 && cost[i][0] != 0){
            res = Math.min(res,cost[i][0] + currCost);
            return;
        }
        for(int j = 0;j<n;j++){
            if(cost[i][j] != 0 && !visited[j]){
                visited[j] = true;
                helper(cost, n, j, currCost + cost[i][j], count+1, visited);
                visited[j] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cost = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                cost[i][j] = sc.nextInt();
            }
        }
        System.out.println(minCost(cost,n));
        sc.close();
    }
}