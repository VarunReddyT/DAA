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
