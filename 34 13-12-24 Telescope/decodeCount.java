// Given a positive number, map its digits to the corresponding alphabet in the mapping table [(1, 'A'), (2, 'B'),(26, 'Z')], 
// and return the count of the total number of decodings possible. 

// Assume that the input number can be split into valid single-digit or two-digit numbers 
// that are present in the mapping table.

// A single-digit between 1 to 9 can be mapped to a corresponding alphabet between A to I.
// Two digits between 10 to 26 can be mapped to a corresponding alphabet between J to Z.

// input format: an intger number 
// output format : an integer number

// Input:  123
// Output: 3
// Explanation : with 123 combination we can form [ABC(123), AW(A=1,W=23), LC(L=12 and C=3)]

// Input:  1221
// Output: 5
// Explanation :with 1221 combination we can form [ABBA, ABU, AVA, LBA, LU]