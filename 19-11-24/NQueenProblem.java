// Akbar used to play chess with Birbal almost every evening.
// Once Akbar has challanged Birbal to place the queens in each row of the board,
// such that no queen should attack another queen on the board.

// You are given an integer N, indicates the size of the board as N*N.
// Your task is to help Birbal to find and win in this challange, 
// if there is a solution, print the answer as shown in the samples
// Otherwise, print "No Solution"

// Input Format:
// -------------
// An integer N, size of the chess board.

// Output Format:
// --------------
// Print any possible solution.


// Sample Input-1:
// ---------------
// 4

// Sample Output-1:
// ----------------
// 0010
// 1000
// 0001
// 0100

// Sample Input-2:
// ---------------
// 3

// Sample Output-2:
// ----------------
// No Solution

import java.util.*;

public class NQueenProblem {
	int N;

	/* A utility function to print solution */
	void printSolution(int board[][])
	{
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(" " + board[i][j]
								+ " ");
			System.out.println();
		}
	}
    
    //Your utility functions goes here
	boolean solveNQ(){
	    //Write your code here and return boolean value
		return false;
		
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		NQueenProblem Queen = new NQueenProblem();
		Queen.N=sc.nextInt();
		Queen.solveNQ();
		sc.close();
	}
}