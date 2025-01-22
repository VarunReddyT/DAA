import java.util.*;

public class LCSDP {
    /*
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     */
    public static int lcs(String text1, String text2) {
        int[] dp = new int[text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            int prev = dp[0];
            for (int j = 1; j < dp.length; j++) {
                int temp = dp[j];
                if (text1.charAt(i) != text2.charAt(j - 1)) {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                } else {
                    dp[j] = prev + 1;
                }
                prev = temp;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }

    public static void main(String args[]) {
        // asian always
        // abcde adobe
        // abcde abode
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(lcs(s1, s2));
        sc.close(); 
    }
}