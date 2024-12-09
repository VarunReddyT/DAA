// Jadav Payeng, "The Forest Man of India", 
// started planting the seeds in a M*N grid land.
// Each cell in the grid land is planted with a seed.
// After few days, some seeds grow into saplings indicates with '1',
// and the rest are dead seeds indicates with '0'.

// One or more saplings are connected either horizontally, vertically or diagonally with each other, form a sapling-group. 
// There may be zero more sapling-groups in the grid land.

// Jadav Payeng wants to know the biggest sapling-group in that grid land.

// You are given the M * N grid, filled with 0's and 1's.
// You are task is to help Jadav Payeng to find the number of saplings in 
// the largest sapling-group.

// Input Format:
// -------------
// Line-1: Two integers M and N, the number of rows and columns in the grid-land.
// Next M lines: contains N space-separated integers .

// Output Format:
// --------------
// Print an integer, the number of saplings in the 
// largest sapling-group in the given grid-land.

// Sample Input-1:
// ---------------
// 5 4
// 0 0 1 1
// 0 0 1 0
// 0 1 1 0
// 0 1 0 0
// 1 1 0 0

// Sample Output-1:
// ----------------
// 8

// Sample Input-2:
// ---------------
// 5 5
// 0 1 1 1 1
// 0 0 0 0 1
// 1 1 0 0 0
// 1 1 0 1 1
// 0 0 0 1 0

// Sample Output-2:
// ----------------
// 5

import java.util.*;

public class maxArea {
    public static int getMaxArea(int[][] matrix, int m, int n) {
        int[] neighbourRow = { -1, -1, -1, 0, 1, 1, 1, 0 };
        int[] neighbourCol = { -1, 0, 1, 1, 1, 0, -1, -1 };

        int maxArea = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    queue.add(new int[] { i, j });
                    int currentArea = 0;

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        currentArea++;
                        int row = curr[0];
                        int col = curr[1];
                        for (int d = 0; d < 8; d++) {
                            int newRow = row + neighbourRow[d];
                            int newCol = col + neighbourCol[d];

                            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                                    matrix[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                                visited[newRow][newCol] = true;
                                queue.add(new int[] { newRow, newCol });
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        return maxArea;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(getMaxArea(matrix, m, n));

        sc.close();
    }
}