// You are a wedding decorator responsible for decorating a wall of size M * N using two different colored balloons. 
// The balloons can either be blue or white. 
// The blue-colored balloons form distinct shapes, where each shape consists of blue balloons connected in one of the four cardinal directions (up, down, left, or right). 
// White balloons serve as separators between blue balloon shapes.

// Blue-colored balloons are represented by the digit 1, while white-colored balloons are represented by the digit 0 in a 2D matrix. 
// Your task is to count the number of distinct shapes formed by the blue balloons on the wall.

// Two shapes are considered distinct if one shape cannot be exactly transformed into the other by shifting (translation).

// Input Format:
// -------------
// Line-1: Two space-separated integers M and N, representing the size of the wall (M rows and N columns).
// Line-2 to M: The next M lines each contain N space-separated integers, either 0 or 1, where 1 represents a blue balloon and 0 represents a white balloon.

// Output Format:
// ---------------
// Line-1: An integer representing the number of distinct shapes formed by blue balloons.

// Constraints:
// ------------
// *1 ≤ M, N ≤ 50
// *The matrix consists only of 0s and 1s.

// Sample Input-1:
// ---------------
// 4 5
// 1 1 0 0 0
// 1 1 0 0 0
// 0 0 0 1 1
// 0 0 0 1 1

// Sample Output-1:
// ----------------
// 1

// Explanation:
// ------------
// In the given input, two shapes are formed by blue balloons. However, both shapes are identical in form, so the output is 1.

// Sample Input-2:
// ---------------
// 5 5
// 1 1 0 1 1
// 1 0 0 0 1
// 0 0 0 0 0
// 1 0 0 0 1
// 1 1 0 1 1

// Sample Output-2:
// ----------------
// 4

// Explanation:
// -------------
// There are four distinct shapes formed by the blue balloons.

import java.util.*;
public class distIslandsBFS{
    public static String distIslands(int[][] grid, Queue<int[]> queue,int n, int m){
        StringBuilder sb = new StringBuilder();
        int[] neighbourRow = {-1,0,1,0};
        int[] neighbourCol = {0,1,0,-1};
        char[] direction = {'l','t','r','d'};

        while(!queue.isEmpty()){
            int[] top = queue.poll();
            int r = top[0];
            int c = top[1];
            
            for(int i = 0;i<4;i++){
                int nr = r+neighbourRow[i];
                int nc = c+neighbourCol[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                    grid[nr][nc] = 0;
                    queue.offer(new int[]{nr,nc});
                    sb.append(direction[i]);
                }
                else{
                    sb.append('b');
                }
            }
        }
        return sb.toString();
    }
    public static HashSet<String> islands(int[][] grid, int n, int m, Queue<int[]> queue){
        HashSet<String> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                    grid[i][j] = 0;
                    set.add(distIslands(grid, queue, n, m));
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
        Queue<int []> queue = new LinkedList<>();
        
        HashSet<String> set = islands(grid,n,m,queue);
        
        System.out.println(set.size());
        sc.close();
    }
}