import java.util.*;

/*
 * T(n)=O(4^n)
 */
public class pathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxGold = Math.max(maxGold, getMaximumGoldBacktrack(grid, i, j, 0));
            }
        }
        return maxGold;
    }

    private int getMaximumGoldBacktrack(int[][] grid, int i, int j, int curGold) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return curGold;
        curGold += grid[i][j];
        int temp = grid[i][j];
        int maxGold = curGold;
        grid[i][j] = 0;
        maxGold = Math.max(maxGold, getMaximumGoldBacktrack(grid, i + 1, j, curGold));
        maxGold = Math.max(maxGold, getMaximumGoldBacktrack(grid, i, j + 1, curGold));
        maxGold = Math.max(maxGold, getMaximumGoldBacktrack(grid, i - 1, j, curGold));
        maxGold = Math.max(maxGold, getMaximumGoldBacktrack(grid, i, j - 1, curGold));
        grid[i][j] = temp;
        return maxGold;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int grid[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        System.out.println(new pathWithMaximumGold().getMaximumGold(grid));
        sc.close();
    }
}