// Pranav has a puzzle board filled with square boxes in the form of a grid.
// Some cells in the grid may be empty. '0' - indicates empty, '1' - indicates a box. 

// The puzzle board has some patterns formed with boxes in it, 
// the patterns may be repeated. The patterns are formed with boxes (1's) only, 
// that are connected horizontally and vertically but not diagonally.

// Pranav wants to find out the number of unique patterns in the board.

// You are given the board in the form of a grid M*N, filled wth 0's and 1's.
// Your task is to help Pranav to find the number of unique patterns in the puzzle board.

// Input Format:
// -------------
// Line-1: Two integers M and N, the number of rows and columns in the grid-land.
// Next M lines: contains N space-separated characters ['0','1'].

// Output Format:
// --------------
// Print an integer, the number of unique patterns in the puzzle board.


// Sample Input-1:
// ---------------
// 5 5
// 0 1 0 1 1
// 1 1 1 0 1
// 0 1 0 1 0
// 1 0 1 1 1
// 1 1 0 1 0

// Sample Output-1:
// ----------------
// 3

// Explanation-1:
// ------------
// The unique patterns are as follows:
//   1			 1 1		1 
// 1 1 1		   1  	,	1 1
//   1		,	
   
   
// Sample Input-2:
// ---------------
// 6 6
// 1 1 0 0 1 1
// 1 0 1 1 0 1
// 0 1 0 1 0 0
// 1 1 0 0 0 1
// 0 0 1 0 1 1
// 1 1 0 1 0 0

// Sample Output-2:
// ----------------
// 5

// Explanation-2:
// ------------
// The unique patterns are as follows:
// 1 1		1 1		    1			1 1 	1
// 1   	  1         1 1 			

import java.util.*;
public class distinctIslandDFS{
    public static String distIslands(int[][] grid, Stack<int[]> stack,int n, int m){
        StringBuilder sb = new StringBuilder();
        int[] neighbourRow = {-1,0,1,0};
        int[] neighbourCol = {0,1,0,-1};
        char[] direction = {'l','t','r','d'};

        while(!stack.isEmpty()){
            int[] top = stack.pop();
            int r = top[0];
            int c = top[1];
            
            for(int i = 0;i<4;i++){
                int nr = r+neighbourRow[i];
                int nc = c+neighbourCol[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                    grid[nr][nc] = 0;
                    stack.push(new int[]{nr,nc});
                    sb.append(direction[i]);
                }
                else{
                    sb.append('b');
                }
            }
        }
        return sb.toString();
    }
    public static HashSet<String> islands(int[][] grid, int n, int m, Stack<int[]> stack){
        HashSet<String> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    stack.push(new int[]{i,j});
                    grid[i][j] = 0;
                    set.add(distIslands(grid, stack, n, m));
                }
            }
        }
        return set;
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
        Stack<int []> stack = new Stack<>();
        HashSet<String> set = islands(grid, n, m, stack);
        System.out.println(set.size());
        sc.close();
    }
}