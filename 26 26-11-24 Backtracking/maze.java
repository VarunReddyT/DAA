// You are entering into a maze N*N grid consist of(0's and 1's)
// Initially you will start from (0,0) position in the maze, 
// Your target is to reach the end position (N-1, N-1).

// Among the four directions available(top, down, left, right),
// you can move in two directions only, right and down.

// In the maze, '0' indicates dead end and '1' indicates open way. 
// You can travel through only open way.
// For Example:-
// Given Maze of size N=4 , starting position is (0, 0),
// 1 0 0 0
// 1 1 0 1
// 0 1 0 0
// 1 1 1 1

// You can reach the (3, 3) position in the following way.
// 1 0 0 0
// 1 1 0 0
// 0 1 0 0
// 0 1 1 1

// Return true, if you can reach the end position(N-1, N-1).
// otherwise return false.

// Input Format:
// -------------
// Line-1 -> An integer N, size of square board.
// Next N lines -> N space separated integers 

// Output Format:
// --------------
// Print a boolean value.

// Sample Input-1:
// ---------------
// 4
// 1 0 0 0
// 1 1 0 1
// 0 1 0 0
// 1 1 1 1

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// 4
// 1 1 0 0
// 1 0 0 1
// 0 1 1 0
// 1 0 0 1

// Sample Output-2:
// ----------------
// false