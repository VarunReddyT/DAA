package Strings;
import java.util.*;

public class LCSRecursive {
    /*
     * Time Complexity: O(2 ^ n)
     * Space Complexity: O(1)
     */
    /*
     * Consider the input strings abcde and abode
     * Last characters match for the strings. So length of LCS can be written as:
     * lcs("abcde", "abode") = 1 + lcs("abcd", "abod")
     * Consider the input strings abcde and aboda
     * Last characters do not match for the strings. So length of LCS can be written
     * as:
     * lcs("abcde", "aboda") = Math.max(lcs("abcde", "abod"), lcs("abcd", "aboda"))
     */
    public int lcs(char[] c1, char[] c2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (c1[m - 1] == c2[n - 1])
            return 1 + lcs(c1, c2, m - 1, n - 1);
        else
            return Math.max(lcs(c1, c2, m, n - 1), lcs(c1, c2, m - 1, n));
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(new LCSRecursive().lcs(s1.toCharArray(), s2.toCharArray(),s1.length(), s2.length()));
        sc.close();
    }
}