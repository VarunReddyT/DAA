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

class hamiltonianCycle
{
	static int V;
	
	void hamCycle(int graph[][]){
		//Write your code here
		int[] path = new int[V];
		Arrays.fill(path,-1);
		path[0] = 0;
		if(hamCycleUtil(graph,path,1)==false){
		    System.out.println("No Solution");
		    return;
		}
		printSolution(path);
	}
    
    //Your utility functions goes here
    boolean hamCycleUtil(int[][] graph, int[] path, int pos){
        if(pos==V){
            if(graph[path[pos-1]][path[0]]==1){
                return true;
            }
            return false;
        }
        for(int i = 1;i<V;i++){
            if(isSafe(graph,path,pos,i)){
				// System.out.println("Index : "+path[pos-1]+" For Index: "+i);
                path[pos] = i;
                if(hamCycleUtil(graph,path,pos+1)){
                    return true;
                }
                path[pos] = -1;
            }
        }
        return false;
    }
    
    boolean isSafe(int[][] graph, int[] path, int pos, int i){
        if(graph[path[pos-1]][i]==0){ // Check connection
            return false;
        }
        for(int v = 0;v<V;v++){
            if(path[v]==i){
                return false;
            }
        }
        return true;
    }
    void printSolution(int[] path){
        for(int i = 0;i<V;i++){
            System.out.print(path[i]+" ");
        }
        System.out.print(path[0]);
    }
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		V = sc.nextInt();
		int graph[][]=new int[V][V];

		for(int i=0;i<V;i++)
			for(int j=0;j<V;j++)
				graph[i][j]=sc.nextInt();

		hamiltonianCycle obj = new hamiltonianCycle();
		obj.hamCycle(graph);
		sc.close();
	}
}