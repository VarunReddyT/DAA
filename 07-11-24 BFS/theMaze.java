// You are given an N×N grid that represents a maze. 
// In this maze: Each cell contains either a 0 or 1.
//  --1 indicates an open path where you can walk.
//  --0 indicates a dead-end where you cannot pass.

// You start at the top-left corner of the maze, i.e., position (0, 0).
// Your target is to reach the bottom-right corner of the maze, i.e., position (N-1, N-1).
// In the maze, you can move only right or down from each cell.

// Objective: Determine if there exists a path from the start (0, 0) to the end (N-1, N-1) that passes only through cells marked 1. 
// If such a path exists, return true; otherwise, return false.

// Input Format:
// -------------
// Line-1: The first line contains an integer N, the size of the square grid.
// Line 2 to N: The next N lines each contain N space-separated integers (either 0 or 1), representing the maze.

// Output Format:
// --------------
// Line-1: Print true if a path exists from (0, 0) to (N-1, N-1), otherwise print false.

// Constraints:
// ------------
// * 1 ≤ N ≤ 100
// * Each cell in the grid is either 0 or 1.

// Sample Input-1:
// ---------------
// 4
// 1 0 0 0
// 1 1 0 1
// 0 1 0 0
// 1 1 1 1

// Sample Output-1:
// ----------------
// true

// Explanation: There exists a path from (0, 0) to (3, 3).

// Sample Input-2:
// ---------------
// 4
// 1 1 0 0
// 1 0 0 1
// 0 1 1 0
// 1 0 0 1

// Sample Output-2:
// ----------------
// false

// Explanation: There is no valid path from (0, 0) to (3, 3).

import java.util.*;

public class theMaze{
    public static boolean path(int[][] grid, int n,Queue<int[]> queue){
        int[] neighbourRow = {1,0};
        int[] neighbourCol = {0,1};
        while(!queue.isEmpty()){
            int[] top = queue.poll();
            int r = top[0];
            int c = top[1];
            if(r==n-1 && c==n-1){
                return true;
            }
            for(int i = 0;i<2;i++){
                int nr = r + neighbourRow[i];
                int nc = c + neighbourCol[i];
                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==1){
                    queue.offer(new int[]{nr,nc});
                    grid[nr][nc] = 0;
                }
            }
        }
        return false;
    }
    public static boolean validPath(int[][] grid, int n){
        Queue<int[]> queue = new LinkedList<>();

        if(grid[0][0] == 0 || grid[n-1][n-1] == 0){
            return false;
        }
        queue.offer(new int[]{0,0});
        grid[0][0] = 0;
        return path(grid, n, queue);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(validPath(grid,n));
        sc.close();
    }
}