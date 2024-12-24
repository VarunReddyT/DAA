// A warehouse is organizing its items for dispatch. Each item is represented 
// by a character in a string s, and the order of characters in the string 
// represents the order of items in the storage line.

// The warehouse wants to divide the items into distinct packages such that:
// 	- Each type of item (character) appears in at most one package.
// 	- The packages are created in the same order as the original line.
	
// Your task is to determine the sizes of the packages. The packages must be 
// contiguous, and after concatenating all the packages in order, the resulting 
// sequence should match the original item line.

// Input Format:
// -------------
// A string, S

// Output Format:
// --------------
// A list of integers representing the sizes of the packages.

// Sample Input-1:
// ---------------
// ababcbacadefegdehijhklij

// Sample Output-1:
// ----------------
// [9, 7, 8]


// Sample Input-2:
// ---------------
// eccbbbbdec

// Sample Output-2:
// ----------------
// [10]