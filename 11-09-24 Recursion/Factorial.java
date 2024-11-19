// Day4_Program1
// Given a non-negative integer n, compute the factorial of n. 
// The factorial of a non-negative integer n is the product of all positive integers less than or equal to n. 
// The factorial of 0 is defined as 1.

// The formula for the factorial of n is:
// n! = n × (n-1) × (n-2) × ... × 1

// Constraints:
// -------------
// 0 ≤ n ≤ 10⁵ (Handle large inputs efficiently).
// Ensure that your solution can handle large values of n without exceeding time limits or running into integer overflow.

// Input Format:
// -------------
// Line-1: A single integer n, representing the number whose factorial needs to be computed.

// Output Format:
// --------------
// Line-1: A single integer, representing the factorial of n.


// Sample Input-1: 
// ----------------
// 5

// Sample Output-1: 
// -----------------
// 120

// Sample Input-2: 
// ---------------
// 0

// Sample Output-2: 
// ----------------
// 1

import java.util.*;
import java.math.*;

public class Factorial{
    static public BigInteger factorial(BigInteger n){
        if(n==BigInteger.valueOf(0) || n==BigInteger.valueOf(1)){
            return BigInteger.valueOf(1);
        }
        return n.multiply(factorial(n.subtract(BigInteger.valueOf(1))));
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial(BigInteger.valueOf(n)));
        sc.close();
    }
}