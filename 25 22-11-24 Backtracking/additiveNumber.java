// An additive number is a string whose digits can form an additive sequence.

// A valid additive sequence should contain at least three numbers. 
// Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

// Given a string containing only digits, return true if it is an additive number or false otherwise.

// Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

// Input Format:
// --------------
// Line-1: An integer

// Output Format:
// --------------
// Line-1: A boolean value
// Sample Input-1:
// ---------------
// 112358

// Sample Output-1:
// ---------------
// true

// Explanation: 
// The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
// 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8


// Sample Input-2:
// ---------------
// 199100199

// Sample Output-2:
// ---------------
// true

// Explanation: 
// The additive sequence is: 1, 99, 100, 199. 
// 1 + 99 = 100, 99 + 100 = 199
 
// Sample Input-3:
// ---------------
// 789

// Sample Output-3:
// ---------------
// false


// Constraints:
// ------------
// 1 <= num.length <= 35, num consists only of digits
// Time complexity: O(N^2)
// Space complexity: O(1)