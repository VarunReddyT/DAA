// You are given an array of integers that can include both positive and negative numbers. 
// Your task is to find the minimum possible product of a non-empty subset of the given array.

// Rules:
// -The subset must contain at least one element.
// -The product is the result of multiplying all the numbers in the subset.
// -If the array contains only one element, that element is the result.
// -You can ignore zeros in the subset product calculation.

// Input Format:
// -------------
// Line-1: An integer N, the number of elements in the array.
// Line-2: N space-separated integers representing the elements of the array.

// Output Format:
// --------------
// Line-1: Print a single integer representing the minimum product possible from a subset of the given array.

// Constraints:
// ------------
// 1 ≤ N ≤ 100
// -1000 ≤ array[i] ≤ 1000

// Sample Input-1:
// ---------------
// 5
// -1 -1 -2 4 3

// Sample Output-1:
// ----------------
// -24

// Explanation: The minimum product can be achieved by choosing the subset {-1, -1, -2, 4} which results in the product -24.

// Sample Input-2:
// ---------------
// 3
// -1 0 -2

// Sample Output-2
// ----------------
// -2

// Explanation: Since zeroes can be ignored, the minimum product is -2, achieved by the subset {-2}.

// Sample Input-3:
// ---------------
// 6
// 2 3 4 5 -1 -2

// Sample Output-3:
// ----------------
// -240
// Explanation: By choosing the subset {2, 3, 4, 5, -1, -2}, the minimum product is -240.

import java.util.*;
public class minProductSubArray{
    public static int minProd(int n, Scanner sc){
        int product = 1;
        int countZero = 0;
        int countNeg = 0;
        int minPos = Integer.MAX_VALUE;
        int maxNeg = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            int num = sc.nextInt();
            if(num == 0){
                countZero++;
                continue;
            }
            else if(num > 0){   
                minPos = Math.min(minPos,num);
            }
            else{
                countNeg++;
                maxNeg = Math.max(maxNeg, num);
            }
            product *= num;
        }
        if (countZero == n || (countNeg == 0 && countZero > 0)){
            return 0;
        }
        else if (countNeg == 0){
            return minPos;
        }
        else if (countNeg % 2 == 0){
            product = product / maxNeg;
        }
        return product;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(minProd(n,sc));
        sc.close();
    }
}
