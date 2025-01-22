import java.util.*;

public class LCSMemo {
    /*
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     */
    static int[][] dp;

    public int lcs(char[] c1, char[] c2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        // if the same state has already been computed
        if (dp[m - 1][n - 1] != 0) {
            return dp[m - 1][n - 1];
        }
        if (c1[m - 1] == c2[n - 1])
            dp[m - 1][n - 1] = 1 + lcs(c1, c2, m - 1, n - 1);
        else
            dp[m - 1][n - 1] = Math.max(lcs(c1, c2, m, n - 1), lcs(c1, c2, m - 1, n));
        return dp[m - 1][n - 1];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        dp = new int[s1.length() + 1][s2.length() + 1];
        System.out.println(new LCSMemo().lcs(s1.toCharArray(), s2.toCharArray(),s1.length(), s2.length()));
        sc.close();
    }
}