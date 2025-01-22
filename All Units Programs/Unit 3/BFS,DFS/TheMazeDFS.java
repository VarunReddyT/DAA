import java.util.*;

public class TheMazeDFS {
    public static boolean dfs(int[][] grid, int r, int c, int n) {
        if (r == n - 1 && c == n - 1) {
            return true;
        }
        grid[r][c] = 0;
        int[] rowDir = {1, 0};
        int[] colDir = {0, 1};

        for (int i = 0; i < 2; i++) {
            int nr = r + rowDir[i];
            int nc = c + colDir[i];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                if (dfs(grid, nr, nc, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validPath(int[][] grid, int n) {
        if (grid[0][0] == 0 || grid[n - 1][n - 1] == 0) {
            return false;
        }
        return dfs(grid, 0, 0, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(validPath(grid, n));
        sc.close();
    }
}
