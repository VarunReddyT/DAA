// You are given an undirected, connected graph with N vertices and M edges, represented as an adjacency matrix. 
// Your task is to construct the Minimum Spanning Tree (MST) of this graph using Prim's algorithm. 
// The MST is a subgraph that connects all the vertices together, without any cycles, and with the minimum possible total edge weight.

// The adjacency matrix of the graph is a 2D array, where graph[i][j] represents the weight of the edge between vertex i and vertex j. 
// If there is no edge between vertex i and vertex j, the value will be 0.

// Your goal is to write a program that reads the adjacency matrix from input and outputs the edges in the MST along with their respective weights.

// Input Format:
// -------------
// Line-1: Line-1 contains an integer N, the number of vertices in the graph.
// Line-2 to N: Each line contain N integers representing the adjacency matrix of the graph.

// Output Format:
// --------------
// Print the edges of the MST and their corresponding weights in the format: Vertex1 - Vertex2 Weight.

// Sample Input-1:
// ---------------
// 5
// 0 2 0 6 0
// 2 0 3 8 5
// 0 3 0 0 7
// 6 8 0 0 9
// 0 5 7 9 0

// Sample Output-1:
// ----------------
// Edge 	Weight
// 0 - 1	2
// 1 - 2	3
// 0 - 3	6
// 1 - 4	5

// Explanation:
// The graph has 5 vertices, and the minimum spanning tree is constructed by connecting the vertices with the least total weight.
// The algorithm starts from the vertex with the smallest weight and continues to add edges with the least cost that connect the remaining unvisited vertices.

// Constraints:
// -------------
// 1 <= N <= 1000
// 0 <= weight of edge <= 10^4
// The graph is connected and undirected.
