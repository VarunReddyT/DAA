// Find minimum path sum in a triangle shaped matrix

// Given a right-angled triangle-shaped matrix, find the shortest path sum from the top element to any element in the last row of the matrix.

// We can only move down from the present cell at any given time. Hence, the legal movements from cell (x,y) are either (x+1,y) or (x+1,y+1). For example, 
// input format: integer number m number of rows 
//               integer numbers m number of rows enter one integer in first row, two integers in second row, three integers in third row and m number of integers in last row
// output format : intger number

// example :
// case =1
// input =
// 4
// 4
// 1 3
// 1 2 1
// 8 4 5 1
// output =9

// [4]                         [9, 0, 0, 0]
// [1, 3]            —>        [6, 5, 0, 0]
// [1, 2, 1]                   [5, 6, 2, 0]
// [8, 4, 5, 1]                [8, 4, 5, 1]

// case =2
// input =5
// 1
// 1 2
// 1 2 3
// 1 2 3 4
// 1 2 3 4 5
// output =5