// Bob Marley is a jamaican singer, he loves to travel around the globe.
// He planned to travel N famous places and return to the starting station.
// Each place is indicated with numbers from 0 to N-1.
// He will start the travel from Place-0.
 
// You are given an integer N and cost matrix cost[][],a symmetric matrix, 
// where cost[i][j] indicates cost to travel from place-i to place-j and vice-versa, 
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
// 0 25 10 15
// 25 0 10 45
// 10 10 0 5
// 15 45 5 0

// Sample Output-1:
// ----------------
// 55


// Sample Input-2:
// ---------------
// 5
// 0 15 5 12 15
// 15 0 7 13 9
// 5 7 0 10 15
// 12 13 10 0 7
// 15 9 15 7 0

// Sample Output-2:
// ----------------
// 40
