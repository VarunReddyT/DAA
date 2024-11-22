// We build a table of n rows (1-indexed). The table is generated based on the following rules:
// 	The first row (for n = 1) contains a single symbol 0.
// 	For each subsequent row n, every 0 in the previous row is replaced with 01, and every 1 is replaced with 10.

// The problem is to return the k-th symbol (1-indexed) in the n-th row of the table.

// Input Format:
// -------------
// Line-1: An integer, represents n is the row number
// Line-2: An integer, represents k is the position in the row

// Output Format:
// --------------
// Line-1: Return either 0 or 1, representing the k-th symbol in the n-th row.

// Sample Input-1:
// ---------------
// 1 //n
// 1 //k

// Sample Output-1:
// ----------------
// 0

// Sample Input-2:
// ---------------
// 2 //n
// 1 //k

// Sample Output-2:
// ----------------
// 0

// Explanation: 
// row 1: 0
// row 2: 01

// Sample Input-3:
// ---------------
// 2 //n
// 2 //k

// Sample Output-3:
// ----------------
// 1

// Explanation: 
// row 1: 0
// row 2: 01


// Constraints:
// 1 ≤ n ≤ 30
// 1 ≤ k ≤ 2^(n-1)

// Explanation on approach:
// The generation of the rows follows a pattern based on the previous row:
// 	For n = 1, the row is 0.
// 	For n = 2, replace 0 with 01: the row becomes 01.
// 	For n = 3, replace each 0 with 01 and each 1 with 10: the row becomes 0110.
// 	For n = 4, the row becomes 01101001.

// To solve this problem recursively:
// If k is less than or equal to half of the length of the previous row, the value is the same as in the previous row.
// Otherwise, we apply a "NOT" operation to the value in the second half of the previous row.
import java.util.*;

public class Kth_Index{
    static public int kthIndex(int n, int k){
        if(n==1){
            return 0;
        }
        int mid = (int)Math.pow(2,n-2);
        if(k<=mid){
            return kthIndex(n-1,k);
        }
        else{
            return 1 - kthIndex(n-1,k-mid);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(kthIndex(n,k));
        sc.close();
    }
}