// You are tasked with calculating how many complete rows a mason can build while constructing a staircase. 
// The staircase consists of k rows, where the i-th row contains exactly i bricks. 
// The mason has n bricks in total, and the last row of the staircase may be incomplete.

// Your goal is to determine the number of complete rows that can be fully built using the given n bricks. 
// Solve this problem in O(log n) time complexity.

// Input Format:
// --------------
// Line-1: A single integer n, representing the total number of bricks.

// Output Format:
// --------------
// Line-2: Return a single integer representing the number of complete rows that can be fully constructed with the available bricks.

// Constraints:
// ------------
// 0 ≤ n ≤ 10^9

// Sample Input-1:
// ----------------
// 5

// Sample Output-1:
// ----------------
// 2

// Explanation:
// The staircase built with 5 bricks looks like this:
// Row 1: B1
// Row 2: B2 B3
// Row 3: B4 B5 (incomplete)
// Rows 1 and 2 are complete, but row 3 is incomplete. Therefore, the number of complete rows is 2.


// Sample Input-2:
// ---------------
// 10

// Sample Output-2:
// ----------------
// 4

// Explanation:
// The staircase built with 10 bricks looks like this:
// Row 1: B1
// Row 2: B2 B3
// Row 3: B4 B5 B6
// Row 4: B7 B8 B9 B10
// All rows are fully constructed, so the output is 4.


// Sample Input-3:
// ---------------
// 19

// Sample Output-3:
// -----------------
// 5

// Explanation:
// The staircase built with 19 bricks looks like this:
// Row 1: B1
// Row 2: B2 B3
// Row 3: B4 B5 B6
// Row 4: B7 B8 B9 B10
// Row 5: B11 B12 B13 B14 B15 (incomplete)
// Rows 1 through 4 are complete, but row 5 is incomplete. The number of complete rows is 5.

import java.util.*;

public class staircase_AP{
    public static long binarySearch(long n){
        long left = 0;
        long right = n;
        while(left<=right){
            long mid = (left+right)/2;
            long s = (mid*(mid+1))/2;
            if(s>n){
                right = mid-1;
            }
            else{
                left = mid + 1;
            }
        }
        return left-1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        System.out.println(binarySearch(n));
        sc.close();
    }
}
