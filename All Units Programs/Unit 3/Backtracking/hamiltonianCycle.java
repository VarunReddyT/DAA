import java.util.*;

public class hamiltonianCycle {
    static int V;

    void hamCycle(int graph[][]) {
        int[] path = new int[V];
        Arrays.fill(path, -1);
        path[0] = 0;
        if (hamCycleUtil(graph, path, 1) == false) {
            System.out.println("No Solution");
            return;
        }
        printSolution(path);
    }
    boolean hamCycleUtil(int[][] graph, int[] path, int pos) {
        if (pos == V) { // Last position
            if (graph[path[pos - 1]][path[0]] == 1) { // Check connection with 0th index
                return true;
            }
            return false;
        }
        for (int i = 1; i < V; i++) {
            if (isSafe(graph, path, pos, i)) {
                path[pos] = i;
                if (hamCycleUtil(graph, path, pos + 1)) {
                    return true;
                }
                path[pos] = -1;
            }
        }
        return false;
    }

    boolean isSafe(int[][] graph, int[] path, int pos, int i) {
        if (graph[path[pos - 1]][i] == 0) { // Check connection with previous index
            return false;
        }
        for (int v = 0; v < V; v++) {
            if (path[v] == i) { // Check if already visited
                return false;
            }
        }
        return true;
    }

    void printSolution(int[] path) {
        for (int i = 0; i < V; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.print(path[0]);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        int graph[][] = new int[V][V];

        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                graph[i][j] = sc.nextInt();

        hamiltonianCycle obj = new hamiltonianCycle();
        obj.hamCycle(graph);
        sc.close();
    }
}