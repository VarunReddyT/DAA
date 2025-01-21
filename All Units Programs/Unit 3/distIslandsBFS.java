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