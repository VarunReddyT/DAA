import java.util.*;

/*
 * T(n)=O(n!)
 */

public class NQueenProblem {
	int N;

	void printSolution(int board[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
	}

	boolean solveNQ() {
		int[][] board = new int[N][N];
		if (solveNQUtil(board, 0) == false) {
			System.out.println("No Solution");
			return false;
		}
		printSolution(board);
		return true;

	}

	boolean solveNQUtil(int[][] board, int col) {
		if (col >= N) {
			return true;
		}
		for (int i = 0; i < board.length; i++) {
			if (isSafe(board, i, col)) {
				board[i][col] = 1;
				if (solveNQUtil(board, col + 1) == true) {
					return true;
				}
				board[i][col] = 0;
			}
		}
		return false;
	}

	boolean isSafe(int[][] board, int row, int col) {
		for (int i = 0; i < col; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		NQueenProblem Queen = new NQueenProblem();
		Queen.N = sc.nextInt();
		Queen.solveNQ();
		sc.close();
	}
}