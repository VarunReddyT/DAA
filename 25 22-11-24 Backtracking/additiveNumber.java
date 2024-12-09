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

import java.util.*;

public class additiveNumber{
    public static boolean isAdditiveNumber(String number){
        int n = number.length();
        for(int i=1;i<=n/2;i++){
            for(int j=1;j<=(n-i)/2;j++){
                if(isValid(number,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isValid(String number, int i, int j){
        if(number.charAt(0)=='0' && i>1){
            return false;
        }
        if(number.charAt(i)=='0' && j>1){
            return false;
        }
        String num1 = number.substring(0,i);
        String num2 = number.substring(i,i+j);
        String sum;
        int k = i+j;
        while(k<number.length()){
            Long n1 = Long.parseLong(num1);
            Long n2 = Long.parseLong(num2);
            Long n3 = n1+n2;
            sum = n3.toString();
            if(!number.startsWith(sum,k)){
                return false;
            }
            k+=sum.length();
            num1 = num2;
            num2 = sum;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        System.out.println(isAdditiveNumber(number));
        sc.close();
    }
}