// In your English exam, there is a question that asks you to check whether a given string is a palindrome. Using your programming skills, you need to write a program that prints True if the string is the same when reversed, and False otherwise.

// A palindrome is a word, phrase, or sequence that reads the same backward as forward.

// Input Format:
// --------------
// Line-1: A single string str, which may contain lowercase letters.

// Output Format:
// ---------------
// Line-1: Print True if the string is a palindrome, otherwise print False.

// Constraints:
// ------------
// The string can contain up to 1000 characters.


// Sample Input-1: 
// ---------------
// liril

// Sample Output-1: 
// ----------------
// True

// Sample Input-2: 
// ---------------
// genesis

// Sample Output-2: 
// ----------------
// False
import java.util.*;

public class palindrome_recursion_AP{
    public static boolean isPalindrome(String word, int i, int j){
        return helper(word,i,j);
    }
    public static boolean helper(String word, int i, int j){
        if(i>j){
            return true;
        }
        if(word.charAt(i) != word.charAt(j)){
            return false;
        }
        return helper(word,i+1,j-1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        
        boolean res = isPalindrome(word,0,word.length()-1);
        System.out.println(res);
        
        sc.close();
    }
}