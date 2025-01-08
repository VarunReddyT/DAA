import java.util.*;

class CountCornerRectangles {
    public int countCornerRectangles(int[][] grid) {
        if (grid == null || grid.length <= 1 || grid[0].length <= 1) {
            return 0;
        }
        int ans = 0;
        int nrows = grid.length, ncols = grid[0].length;
        for (int i = 0; i < nrows; i++) {
            for (int j = i + 1; j < nrows; j++) {
                for (int k = 0, counter = 0; k < ncols; k++) {
                    if (grid[i][k] + grid[j][k] == 2) {
                        ans += counter++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int grid[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        System.out.println(new CountCornerRectangles().countCornerRectangles(grid));
        sc.close();
    }
}