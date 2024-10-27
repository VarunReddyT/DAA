// You are given a connected, undirected, and weighted graph with V vertices and E edges. 
// Your task is to implement Kruskal's Algorithm to find the Minimum Spanning Tree (MST) of the given graph. 
// The graph is represented using an edge list, where each edge connects two vertices with a specific weight.

// Kruskal’s Algorithm is a greedy algorithm that sorts all the edges in non-decreasing order of their weight and picks the smallest edge, as long as it doesn’t form a cycle with the already included edges in the MST. The algorithm stops when exactly V-1 edges have been added to the MST.

// Input Format:
// --------------
// Line-1: Two integers V and E, where V is the number of vertices and E is the number of edges.
// Line-2 to E: Three integers each: u, v, and w, where u is the source vertex, v is the destination vertex, and w is the weight of the edge connecting u and v.

// Output Format:
// ---------------
// Line-1: An integer, the Minimum Cost of the spanning tree.

// Constraints:
// ------------
// *2 ≤ V ≤ 100
// *1 ≤ E ≤ V(V-1)/2
// *The graph is connected and undirected.
// *Weights of the edges are positive integers.

// Sample Input-1:
// ---------------
// 4 5
// 0 1 10
// 0 2 6
// 0 3 5
// 1 3 15
// 2 3 4

// Sample Output-1:
// ----------------
// 19

// Sample Input-2:
// ---------------
// 3 3
// 0 1 1
// 1 2 2
// 0 2 3

// Sample Output-2:
// ----------------
// 3

import java.util.*;
class Edge{
    int src, dest, weight;
    Edge(int src, int dest, int weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}
class Subset{
    int parent, rank;
    Subset(int parent, int rank){
        this.parent = parent;
        this.rank = rank;
    }
}
public class krushkal{
    public static int findMinimumCost(int v, Edge[] edges){
        Arrays.sort(edges, (a, b) -> a.weight - b.weight);
        Subset[] subsets = new Subset[v];
        for(int i=0; i<v; i++){
            subsets[i] = new Subset(i, 0);
        }
        int cost = 0;
        int count = 0;
        for(Edge edge: edges){
            int x = find(subsets, edge.src);
            int y = find(subsets, edge.dest);
            if(x != y){
                union(subsets, x, y);
                cost += edge.weight;
                count++;
            }
            if(count == v-1){
                break;
            }
        }
        return cost;
    }
    public static int find(Subset[] subsets, int i){
        if(subsets[i].parent != i){
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }
    public static void union(Subset[] subsets, int x, int y){
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if(subsets[xroot].rank < subsets[yroot].rank){
            subsets[xroot].parent = yroot;
        }
        else if(subsets[xroot].rank > subsets[yroot].rank){
            subsets[yroot].parent = xroot;
        }
        else{
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        Edge[] edges = new Edge[e];
        for(int i=0; i<e; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            edges[i] = new Edge(src, dest, weight);
        }
        System.out.println(findMinimumCost(v, edges));
        
        sc.close();
    }
}