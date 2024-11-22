// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down). 
// A strobogrammatic number must consist of only the digits 0, 1, 6, 8, and 9. 
// Each of these digits either remains the same or transforms into another valid strobogrammatic digit when rotated:
// 	0 rotates to 0
// 	1 rotates to 1
// 	6 rotates to 9
// 	8 rotates to 8
// 	9 rotates to 6

// Given an integer n, check is n is strobogrammatic number and prime strobogrammatic number.

// Input Format:
// -------------
// Line-1: A single integer n.

// Output Format:
// --------------
// Line-1: Space separated two boolean values, represents "is strobogrammatic number" and "is prime strobogrammatic number".

// Constraints:
// ------------
// 1 ≤ n ≤ 14


// Sample Input-1:
// ---------------
// 1001

// Sample Output-1: 
// ----------------
// true false


// Sample Input-2:
// ---------------
// 101

// Sample Output-2: 
// ----------------
// true true

// Sample Input-3:
// ---------------
// 9999

// Sample Output-3: 
// ----------------
// false false

import java.util.*;

public class is_strobo_prime_AP{
    static public boolean isStrobo(HashMap<Character,Character> map,String s, int i, int j){
        if(i>j){
            return true;
        }
        if(map.containsKey(s.charAt(i))){
            if(map.get(s.charAt(i)) != s.charAt(j)){
                return false;
            }
            return isStrobo(map, s, i+1, j-1);
        }
        return false;
    }
    static public boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i = 2;i<Math.sqrt(n);i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();

        HashMap<Character,Character> arr = new HashMap<Character,Character>();
        arr.put('0','0');
        arr.put('1','1');
        arr.put('8','8');
        arr.put('6','9');
        arr.put('9','6');

        String a = Integer.toString(n);
        
        boolean strobo = isStrobo(arr,a,0,a.length()-1);
        boolean stroboPrime = false;
        if(strobo){
            stroboPrime = isPrime(n);
        }
        System.out.println(strobo + " " + stroboPrime);
        
        sc.close();
        
    }
}