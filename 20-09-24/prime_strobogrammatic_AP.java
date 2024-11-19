// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down). 
// A strobogrammatic number must consist of only the digits 0, 1, 6, 8, and 9. 
// Each of these digits either remains the same or transforms into another valid strobogrammatic digit when rotated:
// 	0 rotates to 0
// 	1 rotates to 1
// 	6 rotates to 9
// 	8 rotates to 8
// 	9 rotates to 6

// Given an integer n, print all prime strobogrammatic numbers that are of length n 
// and print smallest and largest strobogrammatic numbers of length n.

// Input Format:
// -------------
// Line-1: A single integer n, representing the length of the strobogrammatic numbers to generate.

// Output Format:
// --------------
// Line-1: Return a list of all prime strobogrammatic numbers of length n.
// Line-2: Space separated two values, smallest and largest strobogrammatic numbers of length n.

// Constraints:
// ------------
// 1 ≤ n ≤ 14


// Sample Input-1:
// ---------------
// 2

// Sample Output-1: 
// ----------------
// [11]
// 11 96


// Sample Input-2:
// ---------------
// 5

// Sample Output-2: 
// ----------------
// [16091, 18181, 19861, 61819]
// 10001 99866

// Sample Input-3:
// ---------------
// 4

// Sample Output-3: 
// ----------------
// []
// 1001 9966

// NOTE: Print the results in sorted order to pass the testcases
import java.util.*;
public class prime_strobogrammatic_AP{

    static char[][] digitPair = {{'1','1'},{'8','8'},{'6','9'},{'9','6'}};
    public static ArrayList<String> isStrobogrammatic(int n){
        return helper(n,n);
    }

    public static ArrayList<String> helper(int n, int m){
        if(n == 0){
            return new ArrayList<String>(Arrays.asList(""));
        }
        if(n == 1){
            return new ArrayList<String>(Arrays.asList("0","1","8"));
        }

        ArrayList<String> list = helper(n-2,m);
        ArrayList<String> res = new ArrayList<String>();
        for(int i = 0;i<list.size();i++){
            String s = list.get(i);
            if(n != m){
                res.add("0"+s+"0");
            }
            for(char[] singlePair : digitPair){
                res.add(singlePair[0] + s + singlePair[1]);
            }
        }
        return res;
    }

    public static boolean is_prime(int n){
        if(n<2){
            return false;
        }
        for(int i = 2;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> out = isStrobogrammatic(n);
        
        Collections.sort(out);
        ArrayList<String> res = new ArrayList<String>();
        for(int i = 0;i<out.size();i++){
            if(is_prime(Integer.parseInt(out.get(i)))){
                res.add(out.get(i));
            }
        }
        
        System.out.println(res);

        System.out.print(out.get(0) + " " + out.get(out.size()-1));

        sc.close();
    }

}