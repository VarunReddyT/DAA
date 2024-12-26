// Vihaan is given a pair of words: word1 and word2, he is asked to create a method which
// returns the numbers of characters in a word formed from long lasting frequent posteriority.
// Posteriority is a latest word formed from the native word with few characters removed
// without modifying the corresponding order of the left over characters.
// A frequent posteriority of two words is a posteriority that is frequent to both words.
// Return 0 if no common posteriority.

// Input Format:
// -------------
// Two space separated strings S1, S2.

// Output Format:
// --------------
// Print an integer, the length of longest common subsequence.

// Sample Input-1:
// ---------------
// abcde ace

// Sample Output-1:
// ----------------
// 3

// Sample Input-2:
// ---------------
// acd bef

// Sample Output-2:
// ----------------
// 0

import java.util.*;

public class lcs_tabulation{
    public static int getLCS(String s1, String s2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(getLCS(s1, s2, s1.length(), s2.length()));
        sc.close();
    }
}