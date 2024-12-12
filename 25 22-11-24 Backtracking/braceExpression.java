// Brace
// Naresh is working on expression of words.
// If you give him an expression like, [p,q,r]s[t,u],
// Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
// Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

// Naresh will be given an expression as a string EXP, like the above format.
// He needs to return all words that can be formed in like mentioned above, 
// Can you help Naresh to convert iven expression into a list of words, in lexicographical order.

// NOTE: 
// Expression consist of lowercase alphabets, comma, and square brackets only.

// Input Format:
// -------------
// Line-1: A string EXP, expression.

// Output Format:
// --------------
// Line-1: Print list of words, formed from the expression.

// Sample Input-1:
// ---------------
// [b]c[e,g]k

// Sample Output-1:
// ----------------
// [bcek, bcgk]


// Sample Input-2:
// ---------------
// [a,b][c,d]

// Sample Output-2:
// ----------------
// [ac, ad, bc, bd]


// Sample Input-3:
// ---------------
// [xyz]a[b,c]

// Sample Output-3:
// ----------------
// [xyzab, xyzac]

import java.util.*;

public class braceExpression{
    public static void braceExpressionUtil(String expression,int i, TreeSet<String> result, String s){
        if(i==expression.length()){
            result.add(s);
            return;
        }
        if(expression.charAt(i)=='['){
            int j=i+1;
            while(j<expression.length() && expression.charAt(j)!=']'){
                j++;
            }
            String sub = expression.substring(i+1,j);
            String[] options = sub.split(",");
            for (String option : options) {
                braceExpressionUtil(expression, j + 1, result, s + option);
            }
        }
        else{
            braceExpressionUtil(expression,i+1,result,s+expression.charAt(i));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.next();
        TreeSet<String> result = new TreeSet<>();
        braceExpressionUtil(expression,0,result,"");
        System.out.println(result);
        sc.close();
    }
}