import java.util.*;

/*
 * T(n)=O(n^3)
 */

class OBSTDP {
    int minSearchCostBST(int keys[], int freq[], int n) {
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = freq[i];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {

                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                int sum = fsum(freq, i, j);

                for (int r = i; r <= j; r++) {

                    int c = sum;
                    if (r > i)
                        c += dp[i][r - 1];
                    if (r < j)
                        c += dp[r + 1][j];
                    if (c < dp[i][j])
                        dp[i][j] = c;
                }
            }
        }
        return dp[0][n - 1];
    }

    int fsum(int freq[], int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) {

            if (k >= freq.length)
                continue;
            s += freq[k];
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int keys[] = new int[n];
        int freq[] = new int[n];
        for (int i = 0; i < n; i++)
            keys[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            freq[i] = sc.nextInt();
        System.out.println(new OBSTDP().minSearchCostBST(keys, freq, n));
        sc.close();
    }
}