import java.util.*;

class Graph {
    private int v;
    private LinkedList<Integer> adjList[];

    @SuppressWarnings("unchecked")
    public Graph(int v) {
        this.v = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v1, int v2) {
        adjList[v1].add(v2);
    }

    public void BFS(int source) {
        boolean[] visited = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited[source] = true;
        while (!q.isEmpty()) {
            int vertex = q.poll();
            System.out.print(vertex + " ");
            for (int neighbour : adjList[vertex]) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.offer(neighbour);
                }
            }
        }
    }
}

public class bfs {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 1);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);
        graph.addEdge(4, 0);
        graph.addEdge(4, 3);
        System.out.println("Breadth-First Traversal (starting from vertex 0):");
        graph.BFS(0);
    }
}