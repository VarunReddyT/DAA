// Bob Marley is a jamaican singer, he loves to travel around the globe.
// He planned to travel N famous places and return to the starting station.
// Each place is indicated with numbers from 0 to N-1.
// He will start the travel from Place-0.
 
// You are given an integer N and cost matrix cost[][],a symmetric matrix, 
// where cost[i][j] indiactes cost to travel from place-i to place-j and vice-versa, 
// if cost[i][j]=0, indicates no way to travel from place-i to place-j and vice-versa. 

// Your task is to help Bob Marley, to find the shortest possible travel plan
// to visit every place and returns to starting place-0. 
// Finally print the minimum cost to travel accordingly.

// Input Format:
// -------------
// Line-1: An integer N. 
// Next N lines: N space separated integers, cost of i to j.

// Output Format:
// --------------
// Print an integer, the minimum cost to travel all the places and return to place-0.


// Sample Input-1:
// ---------------
// 4
// 0 10 35 30
// 10 0 25 16
// 24 15 0 20
// 39 24 14 0

// Sample Output-1:
// ----------------
// 64

// Explanation:
// ------------
// Travelling route is: 0 -> 1 -> 3 -> 2 -> 0


// Sample Input-2:
// ---------------
// 5
// 0  20 30 10 11
// 15 0  16 4  2
// 3  5  0  2  4
// 19 6  18 0  3 
// 16 4  7  16 0 
// output =28

// Sample Output-2:
// ----------------
// 28

// Explanation:
// ------------
// Travelling route is: 0 -> 1 -> 3 -> 4 -> 2 -> 0
