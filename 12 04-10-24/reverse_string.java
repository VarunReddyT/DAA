// Aruna as a type writer, typing a document in her laptop. Suddenly her system got
// hacked and whatever she types as words are displaying in reverse and with simple 
// braces. She types only lowercase letters.

// Inorder to get the actual words, Aruna has to reverse each word starting with the
// word which is in innermost most braces and remove those braces.
// Help Aruna to get actual words.

// Constraints:
// ------------
//   - 0 <= word.length <= 2000
//   - Word only contains lower case English characters and parentheses.
//     It's guaranteed that all braces are balanced.


// Input Format:
// -------------
// Line-1: A string, represents an encoded word.

// Output Format:
// --------------
// Line-1: A string, return the original string.


// Sample Input-1:
// ---------------
// {pqrs}

// Sample Output-1:
// ----------------
// srqp


// Sample Input-2:
// ---------------
// {uoy{are}woh}

// Sample Output-2:
// ----------------
// howareyou

// Explanation
// ------------
// Initially "are" will be revesed as "era".
// Then {uoyerawoh} will be reversed.

import java.util.*;

public class reverse_string {
    public static String reverse(String s){
        String res = ""; 
        Stack<String> st = new Stack<>(); 
        int i = 0;
        
        while(i < s.length()){
            String c = s.substring(i, i + 1);
            
            if(!c.equals("}")){ 
                st.push(c);
            } 
            else { 
                String temp = ""; 
                while(!st.peek().equals("{")){
                    temp += st.pop();
                }
                st.pop();
                for(int t = 0; t < temp.length(); t++){
                    st.push(temp.charAt(t) + "");
                }
            }
            i++;
        }
        while(!st.isEmpty()){
            res = st.pop() + res;
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(reverse(s));
        sc.close();
    }
}