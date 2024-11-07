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
public class maxArea{
    public static int distIslands(int[][] grid, Stack<int[]> stack,int n, int m){
        int[] neighbourRow = {-1,-1,-1,0,0,1,1,1};
        int[] neighbourCol = {-1,0,1,-1,1,-1,0,1};
        
        int area = 0;

        while(!stack.isEmpty()){
            int[] top = stack.pop();
            int r = top[0];
            int c = top[1];
            
            area++;
            
            for(int i = 0;i<8;i++){
                int nr = r+neighbourRow[i];
                int nc = c+neighbourCol[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                    grid[nr][nc] = 0;
                    stack.push(new int[]{nr,nc});
                }
            }
        }
        return area;
    }
    public static int islands(int[][] grid, int n, int m){
        int max = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{i,j});
                    grid[i][j] = 0;
                    max = Math.max(distIslands(grid, stack, n, m),max);
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        
        System.out.println(islands(grid,n,m));
        sc.close();
    }
}