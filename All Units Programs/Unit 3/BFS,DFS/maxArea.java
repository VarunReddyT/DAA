import java.util.*;

/*
 * T(n)=O(n*m)
 */
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