// A password detection system for HackerRank accounts detects a password 
// as similar if the number of vowels is equal to the number of consonants in 
// the password. Passwords consist of lowercase English characters only, and 
// vowels are: {'a', 'e', 'i', 'o', 'u'}

// To check the strength of a password and how easily it can be hacked, some 
// manipulations can be made to the password. In one operation, any character 
// of the string can either be incremented or decremented.

// For example:
// 	- 'f' can be incremented to 'g' or decremented to 'e'.
// 	- 'a' cannot be decremented.
// 	- 'z' cannot be incremented.

// Find the minimum number of operations required to make the password similar.


// Input Format:
// -------------
// A single string password consisting of lowercase English letters

// Output Format:
// --------------
// A single integer: the minimum number of operations


// Sample Input-1:
// ---------------
// hack

// Sample Output-1:
// ----------------
// 1

// Explanation:
// ------------
// The password "hack" initially has:
// 1 vowel: 'a', 3 consonants: 'h', 'c', 'k'
// One operation can change 'h' to 'i' (a vowel).
// Resulting string: "iack", which now has 2 vowels ('i', 'a') and 2 consonants 
// ('c', 'k').


// Sample Input-2:
// ---------------
// accomplishment

// Sample Output-2:
// ----------------
// 3

import java.util.*;

public class passwordDetection{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String password = sc.next();
        int vowels = 0;
        int consonants = 0;
        for(int i=0;i<password.length();i++){
            char ch = password.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                vowels++;
            }
            else{
                consonants++;
            }
        }
        System.out.println(Math.abs(consonants-vowels));
        sc.close();
    }
}