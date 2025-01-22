package DP;
import java.util.*;

public class TSPDP {
    static int n;
    static int[][] distance;
    static int allCityVisited;
    static int[][] dp;

    static int tsp(int mask, int currCity) {

        if (mask == allCityVisited) {
            return distance[currCity][0];
        }

        if (dp[mask][currCity] != -1) {
            return dp[mask][currCity];
        }

        int minDis = Integer.MAX_VALUE;

        for (int city = 0; city < n; city++) {

            if ((mask & (1 << city)) == 0) {

                int vmask = mask | (1 << city);
                int dist = distance[currCity][city] + tsp(vmask, city);

                minDis = Math.min(minDis, dist);
            }
        }
        return dp[mask][currCity] = minDis;
    }

    // Initially we make a 2D array of [2^n][n] and initially put -1 at each
    // position
    static int getMinPath_TSP() {
        dp = new int[1 << n][n];
        allCityVisited = (1 << n) - 1;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return tsp(1, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        distance = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                distance[i][j] = sc.nextInt();
        int minPath = getMinPath_TSP();
        System.out.println(Arrays.deepToString(dp));
        System.out.println(minPath);
        sc.close();
    }
}