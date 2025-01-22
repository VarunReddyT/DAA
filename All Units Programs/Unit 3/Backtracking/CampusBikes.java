import java.util.*;

public class CampusBikes {
    int min = Integer.MAX_VALUE;

    public int assignBikes(int[][] workers, int[][] bikes) {
        backtrack(new boolean[bikes.length], 0, workers, bikes, 0);
        return min;
    }

    void backtrack(boolean[] visited, int i, int[][] workers, int[][] bikes, int distance) {
        if (i == workers.length && distance < min)
            min = distance;
        if(i >= workers.length || distance > min){
            return ;
        }
        for (int j = 0; j < bikes.length; j++) {
            if (visited[j])
                continue;
            visited[j] = true;
            backtrack(visited, i + 1, workers, bikes, distance + dist(i, j, workers, bikes));

            visited[j] = false;
        }
    }

    int dist(int i, int j, int[][] workers, int[][] bikes) {
        return Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int bikes[][] = new int[n][2];
        int men[][] = new int[m][2];

        // Coordinates of workers and bikes
        for (int i = 0; i < m; i++) {
            men[i][0] = sc.nextInt();
            men[i][1] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bikes[i][0] = sc.nextInt();
            bikes[i][1] = sc.nextInt();
        }
        System.out.println(new CampusBikes().assignBikes(men, bikes));
        sc.close();
    }
}