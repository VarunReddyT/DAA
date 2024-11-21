// N cities are connected through roads, the cities are numbered from 0 to N-1. 
// The roadmaps are given as a grid of size N*N, roadmap[][], 
// the grid contains 0 and 1 as values grid[i][j]=0, indicates no road 
// between i to j cities, grid[i][j]=1, indicates a road between i and j cities.

// You are given an integer N, and the roadmap[][]of size N*N.
// Your task is to find that there exists a loop in the roadmap, such that 
// there exists a route consists of all the cities eaxctly once and the 
// last city in the route should be connected to first city of the same route directly.

// If you found such route print the route, otherwise print "No Solution"

// Input Format:
// -------------
// Line-1: An integer N, size of the chess board.
// Next N lines: N space separated integers, 0 or 1.

// Output Format:
// --------------
// Print any possible route or "No Solution".

// Sample Input-1:
// ---------------
// 5
// 0 1 0 1 0
// 1 0 1 1 1
// 0 1 0 0 1
// 1 1 0 0 1
// 0 1 1 1 0

// Sample Output-1:
// ----------------
// 0  1  2  4  3  0

// Sample Input-2:
// ---------------
// 5
// 0 1 0 1 0
// 1 0 1 1 1
// 0 1 0 0 1
// 1 1 0 0 0
// 0 1 1 0 0

// Sample Output-2:
// ----------------
// No Solution

import java.util.*;

class HamiltonianCycle
{
	static int V;
	
	void hamCycle(int graph[][]){
		//Write your code here
        
	}
    
    //Your utility functions goes here
    
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		V = sc.nextInt();
		int graph[][]=new int[V][V];

		for(int i=0;i<V;i++)
			for(int j=0;j<V;j++)
				graph[i][j]=sc.nextInt();

		HamiltonianCycle obj = new HamiltonianCycle();
		obj.hamCycle(graph);
        sc.close();
	}
}