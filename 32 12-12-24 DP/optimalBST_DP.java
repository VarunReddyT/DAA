// You are given N nodes of a Binary search tree.
// To search a node in the binary serach tree, it will cost some freq.
// You are given the N nodes as keys[] in sorted order, and the search costs of N nodes
//  as freq[], where freq[i] is the cost to search keys[i] element in the BST.

// The cost to search a BST node is the level of that node multiplied by its freq. The level of the root is 1.

// Your task is to findout the minimum cost of a BST is defines as the total cost of all the BST nodes.
// You can form the BST with any element as the root node.

// Input Format:
// ------------------
// Line-1: An integer N, number of nodes.
// Line-2: N space separate integers, node vals[].
// Line-3: N space separate integers, node cost[].

// Output Format:
// -------------------
// Print an integer, minimum search cost of BST.


// Sample Input-1:
// --------------------
// 3
// 10 20 30
// 23 32 14

// Sample Output-1:
// ----------------------
// 106

// Explanation:
// ----------------
// The BST is: 
// 		20
// 		/\
// 	  10  30

// Sample Input-2:
// --------------------
// 4
// 8 10 12 20
// 26 34 8 50

// Sample Output-2:
// ----------------------
// 210

// Explanation:
// ----------------
// The BST is: 
// 		10
// 		/\
// 	  8  20
// 		/
// 	 12

import java.util.*;

public class optimalBST_DP{
    public static int getMinFreq(int[] freq, int n){
        int[][] dp = new int[n][n];
        for(int i = 0;i<n;i++){
            dp[i][i] = freq[i];
        }
        for(int len = 2;len<=n;len++){
            for(int i = 0;i<=n-len;i++){
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                int sum = 0;
                for(int k = i;k<=j;k++){
                    sum+=freq[k];
                }
                for(int k = i;k<=j;k++){
                    int val = sum;
                    if(k-1>=i){
                        val += dp[i][k-1];
                    }
                    if(k+1<=j){
                        val += dp[k+1][j];
                    }
                    dp[i][j] = Math.min(dp[i][j],val);
                }
            }
        }
        return dp[0][n-1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] keys = new int[n];
        int[] freq = new int[n];
        for(int i = 0;i<n;i++){
            keys[i] = sc.nextInt();
        }
        for(int i = 0;i<n;i++){
            freq[i] = sc.nextInt();
        }
        System.out.println(getMinFreq(freq,n));
        sc.close();
    }
}