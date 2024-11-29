// Given a directed graph represented by an adjacency matrix, where each entry graph[i][j] represents the weight of the edge from vertex i to vertex j. If graph[i][j] is 0, it means there is no direct edge between i and j.

// Your task is to determine the shortest paths from a given source vertex to all other vertices using Dijkstra’s algorithm.

// Input Format:
// -------------
// Line-1: An integer N, representing the number of vertices in the graph.
// Next-N lines: Each line contains N space-separated integers representing the adjacency matrix graph.
// Last-line: An integer src, representing the source vertex.

// Output Format:
// --------------
// A line that says: "Vertex 		Distance from Source".
// Followed by N lines, each containing the vertex number and its shortest distance from the source.

// Constraints:
// ------------
// 1 <= N <= 100
// 0 <= graph[i][j] <= 1000
// 0 <= src < N
// All weights are non-negative integers.

// Sample Input-1:
// ---------------
// 5
// 0 6 5 0 13
// 6 0 12 9 5
// 5 12 0 0 0
// 0 9 0 0 7
// 13 5 0 7 0
// 2

// Sample Output-1:
// ----------------
// Vertex           Distance from Source
// 0                5
// 1                11
// 2                0
// 3                20
// 4                16

// Sample Input-2:
// ---------------
// 9
// 0 4 0 0 0 0 0 8 0
// 4 0 8 0 0 0 0 11 0
// 0 8 0 7 0 4 0 0 2
// 0 0 7 0 9 14 0 0 0
// 0 0 0 9 0 10 0 0 0
// 0 0 4 14 10 0 2 0 0
// 0 0 0 0 0 2 0 1 6
// 8 11 0 0 0 0 1 0 7
// 0 0 2 0 0 0 6 7 0
// 5

// Sample Output-2:
// ----------------
// Vertex           Distance from Source
// 0                11
// 1                12
// 2                4
// 3                11
// 4                10
// 5                0
// 6                2
// 7                3
// 8                6


import java.util.*;

class Pair{
    int vertex;
    int distance;
    public Pair(int vertex, int distance){
        this.vertex = vertex;
        this.distance = distance;
    }
}

public class dijkstraShortestPath{

    public static void dijkstra(int[][] graph, int source, int v){
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2){
                return Integer.compare(p1.distance, p2.distance);
            }
        });
        // PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        int[] distance = new int[v];

        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[source] = 0;

        pq.add(new Pair(source,0));

        boolean[] visited = new boolean[v];

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int u = p.vertex;

            if(visited[u] == true){
                continue;
            }

            visited[u] = true;

            for(int i = 0;i<v;i++){
                if(graph[u][i] != 0 && !visited[i]){
                    int newDist = graph[u][i] + distance[u];
                    if(newDist<distance[i]){
                        distance[i] = newDist;
                        pq.add(new Pair(i, newDist));
                    }
                }
            }
            display(distance, v);
        }

    }

    public static void display(int[] distance,int v){
        System.out.println("Vertex           Distance from Source");
        for(int i = 0;i<v;i++){
            System.out.println(i + "                " + distance[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        
        int[][] graph = new int[v][v];
        
        for(int i = 0;i<v;i++){
            for(int j = 0;j<v;j++){
                graph[i][j] = sc.nextInt();
            }
        }
        int source = sc.nextInt();

        dijkstra(graph,source,v);
        
        sc.close();
    }
}