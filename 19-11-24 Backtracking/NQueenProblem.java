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
				System.out.print(board[i][j]);
			System.out.println();
		}
	}
    
    //Your utility functions goes here
	boolean solveNQ(){
	    //Write your code here and return boolean value
	    int[][] board = new int[N][N];
	    if(solveNQUtil(board,0)==false){
	        System.out.println("No Solution");
	        return false;
	    }
	    printSolution(board);
	    return true;
		
	}
	boolean solveNQUtil(int[][] board, int col){
	    if(col>=N){
	        return true;
	    }
	    for(int i = 0;i<board.length;i++){
	        if(isSafe(board,i,col)){
	            board[i][col] = 1;
	            if(solveNQUtil(board,col+1)==true){
	                return true;
	            }
	            board[i][col] = 0;
	        }
	    }
	    return false;
	}
	boolean isSafe(int[][] board, int row, int col){
	    for(int i = 0;i<col;i++){
	        if(board[row][i]==1){
	            return false;
	        }
	    }
	    for(int i = row, j = col; i>=0 && j>=0; i--, j--){
	        if(board[i][j]==1){
	            return false;
	        }
	    }
	    for(int i = row, j = col; i<board.length && j>=0; i++, j--){
	        if(board[i][j]==1){
	            return false;
	        }
	    }
	    return true;
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