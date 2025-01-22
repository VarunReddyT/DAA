/*
 * T(n)=O(n^2)
 */
import java.util.*;

class LRS {
    public int longestRepeatingSubstring(String s) {
        int n = s.length();
        for (int len = (n - 1); len >= 1; len--) {
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i <= (n - len); i++) {
                String subs = s.substring(i, i + len);
                System.out.println(subs);
                if (set.contains(subs)) {
                    return len;
                }
                set.add(subs);
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(new LRS().longestRepeatingSubstring(s));
        sc.close();
    }
}