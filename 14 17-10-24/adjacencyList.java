// You are given a graph with V vertices and E edges. 
// Your task is to represent this graph using an adjacency list. 
// In this representation, each vertex has a list of adjacent vertices, showing which vertices it is connected to.

// The graph is undirected, meaning if there is an edge between vertex u and vertex v, then both u is connected to v and v is connected to u.

// Input Format:
// -------------
// Line-1: An integer V representing the number of vertices.
// Line-2: An integer E representing the number of edges.
// Next E Lines: The next E lines each contain two integers u and v representing an edge between vertices u and v.

// Output Format:
// --------------
// Print the adjacency list of the graph, where each vertex's adjacent vertices are space-separated.

// Constraints:
// ------------
// *2 <= V <= 1000 (The number of vertices)
// *0 <= u, v < V (Valid vertices indices)
// *0 <= E <= V*(V-1)/2 (Maximum number of edges for an undirected graph)

// Sample Input-1:
// ---------------
// 5
// 4
// 0 1
// 0 2
// 1 3
// 3 4

// Sample Output-1:
// ----------------
// 0: 1 2
// 1: 0 3
// 2: 0
// 3: 1 4
// 4: 3

// Explanation:
// ------------
// Vertex 0 is connected to vertices 1 and 2.
// Vertex 1 is connected to vertices 0 and 3.
// Vertex 2 is connected to vertex 0.
// Vertex 3 is connected to vertices 1 and 4.
// Vertex 4 is connected to vertex 3.

// Sample Input-2:
// ---------------
// 3
// 2
// 0 1
// 2 1

// Sample Output-2:
// ---------------
// 0: 1
// 1: 0 2
// 2: 1

import java.util.*;

public class adjacencyList{

    public static void display(ArrayList<ArrayList<Integer>> adjList, int v){
        for (int i=0; i<v;i++) {
            System.out.print(i+": ");
            for (int j : adjList.get(i)) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i=0;i<v;i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjList.get(v1).add(v2);
            if(v1!=v2)
            adjList.get(v2).add(v1); 
        }

        display(adjList,v);

        sc.close();

    }
}