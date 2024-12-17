// The Valid shortcuts of a string "abcd", are as follows:
// abcd, a1cd, ab1d, abc1, 2cd, a2d, ab2, 1b1d, 1bc1,a1c1, 1b2, 2c1, 3d, a3, 4

// You are given a string S and shortcut string  SC, 
// Your task is to find out whether the string matches with the given shortcut or not.
// if matched print true, else false.

// Note:
// String S contains only lowercase letters and String SC contains only lowercase letters and digits.

// Input Format:
// -------------
// Two space separated Strings S and SC

// Output Format:
// --------------
// Print a boolean value


// Sample Input-1:
// ---------------
// internationalization i12iz4n

// Sample Output-1:
// ----------------
// true

// Sample Input-2:
// ---------------
// apple a2e

// Sample Output-2:
// ----------------
// false

import java.util.*;

public class checkAbbreviation {
    public static boolean validateAbbr(String s, String abbr){
        int index = 0;
        int num = 0;
        for(int i = 0;i<abbr.length();i++){
            if(Character.isDigit(abbr.charAt(i))){
                if(abbr.length() == 1 && Integer.parseInt(abbr.charAt(i)+"") != s.length()){
                    return false;
                }
                if(num == 0 && abbr.charAt(i) == '0'){
                    return false;
                }
                num = num*10 + Integer.parseInt(abbr.charAt(i)+"");
            }
            else{
                index += num;
                num = 0;
                if(s.charAt(index) != abbr.charAt(i)){
                    return false;
                }
                index++;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String abbr = sc.next();
        System.out.println(validateAbbr(s,abbr));
        sc.close();
    }
}
