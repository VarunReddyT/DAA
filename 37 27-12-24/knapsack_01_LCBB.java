// Mr. Dharma went shopping at D-Mart with a basket that can hold a maximum quantity of C. 
// He has a wishlist of N products, each with a specific cost and quantity.

// Dharma wants to maximize the total cost of products he can carry in the basket 
// while ensuring the total quantity does not exceed the basket's capacity.

// Your task is to help Mr. Dharma select the products optimally 
// using the following LC Branch-and-Bound Approach: 
// Use a decision tree to explore all combinations while maintaining efficiency by pruning suboptimal branches.

// Input Format:
// -------------
// Line-1: Two space-separated integers N (number of products) and C (basket capacity).
// Line 2 to N: Each contain two space-separated integers: cost i and quantity i, representing the cost and quantity of the i th product.

// Output Format:
// --------------
// Line-1: Print an integer, the maximum total cost Dharma can achieve without exceeding the basket's capacity.


// Sample Input-1:
// ---------------
// 4 15
// 12 6
// 10 2
// 10 4
// 18 9

// Sample Output-1:
// ----------------
// 38

// Explanation:
// ------------
// Quantities selected: 2,4,9 (total = 15)
// Costs added: 10,10,18 (total = 38)


// Sample Input-2:
// ---------------
// 4 21
// 18 6
// 20 3
// 14 5
// 18 9 

// Sample Output-2:
// ----------------
// 56

// Explanation:
// ------------
// Quantities selected: 6,3,9 (total = 18)
// Costs added: 18,20,18 (total = 56)
