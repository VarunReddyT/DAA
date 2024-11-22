// Given a integer value N, indicates number of bits in a binary number.

// An n-bit gray code sequence is a sequence of 2n integers where:
//  -Every integer is in the inclusive range [0, 2n - 1],
//  -The first integer is 0,
//  -An integer appears no more than once in the sequence,
//  -The binary representation of every pair of adjacent integers differs by exactly one bit, and
//  -The binary representation of the first and last integers differs by exactly one bit.

// Given an integer n, return any valid n-bit gray code sequence.

// Input Format:
// -------------
// Line-1: A integer N

// Output Format:
// --------------
// Line-1: Print the list of integer values.

// Sample Input-1:
// ---------------
// 2

// Sample Output-1:
// ----------------
// [0, 1, 3, 2]

// Explanation:
// ------------
// 00 - 0
// 01 - 1
// 11 - 3
// 10 - 2

// Sample Input-2:
// ---------------
// 3

// Sample Output-2:
// ----------------
// [0, 1, 3, 2, 6, 7, 5, 4]

// Explanation:
// ------------
// 000 - 0
// 001 - 1
// 011 - 3
// 010 - 2
// 110 - 6
// 111 - 7
// 101 - 5
// 100 - 4
