// You are given an integer n. 
// Your task is to find all possible unique combinations of integers greater than 1 that multiply together to form n.

// Each combination should be represented as a list of integers, 
// and the combinations should be sorted lexicographically based on the factors. 
// The output should not include duplicate combinations.

// Input Format:
// -------------
// Line-1: An integer n where n > 1.

// Output Format:
// ---------------
// Line-1: A list of lists, where each sublist contains integers that represent one valid factor combination of n.

// Sample Input-1:
// ---------------
// 12

// Sample Output-1:
// ----------------
// [[2, 6], [2, 2, 3], [3, 4]]


// Sample Input-2:
// ---------------
// 15

// Sample Output-2:
// ----------------
// [[3, 5]]


// Sample Input-3:
// ---------------
// 32

// Sample Output-3:
// ----------------
// [[2, 16], [2, 2, 8], [2, 2, 2, 4], [2, 2, 2, 2, 2], [4, 8]]

// import java.util.*;

// public class factorCombinations {
//     public static List<List<Integer>> getFactors(int n) {
//         List<List<Integer>> result = new ArrayList<>();
//         getFactorsHelper(n, 2, new ArrayList<>(), result);
//         return result;
//     }
    
//     private static void getFactorsHelper(int n, int start, List<Integer> current, List<List<Integer>> result) {
//         if (n == 1) {
//             if (current.size() > 1) { 
//                 result.add(new ArrayList<>(current));
//             }
//             return;
//         }
//         for (int i = start; i <= Math.sqrt(n); i++) {
//             if (n % i == 0) {
//                 current.add(i);
//                 getFactorsHelper(n / i, i, current, result); 
//                 current.remove(current.size() - 1);
//             }
//         }
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         List<List<Integer>> result = getFactors(n);
//         System.out.println(result);
//         sc.close();
//     }
// }
