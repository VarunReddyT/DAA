// With the growing trend of shorthand writing, 
// people often replace parts of a word with their lengths to create short-forms. 
// A valid short-form can be created by replacing non-overlapping and non-adjacent substrings with their respective lengths.

// You are given a word as input. 
// Your task is to generate all possible short-forms of the given word and return them in lexicographical order.

// Input Format:
// --------------
// Line-1: A single string W representing the word.

// Output Format:
// ---------------
// A list of strings representing all possible short-forms of the word W in lexicographical order.

// Constraints:
// -------------
// 1 ≤ len(W) ≤ 10
// The word W consists of lowercase English letters only.

// Sample Input-1:
// ---------------
// kmit

// Sample Output-1:
// ----------------
// [1m1t, 1m2, 1mi1, 1mit, 2i1, 2it, 3t, 4, k1i1, k1it, k2t, k3, km1t, km2, kmi1, kmit]


// Sample Input-2:
// ---------------
// cse

// Sample Output-2:
// ----------------
// [1s1, 1se, 2e, 3, c1e, c2, cs1, cse]

import java.util.*;

public class generalizedAbbrevation {
    List<String> result = new ArrayList<>();
    void backtrack(String input, StringBuilder curr, int skip , int currLength){
        int len = curr.length();
        if(currLength == input.length()){
            if(skip>0){
                curr.append(skip);
            }
            result.add(curr.toString());
        }
        else{
            backtrack(input, curr, skip+1, currLength+1);
            if(skip>0){
                curr.append(skip);
            }
            curr.append(input.charAt(currLength));
            backtrack(input, curr, 0, currLength+1);
        }
        curr.setLength(len);
    }
    List<String> genAbb(String input){
        StringBuilder s = new StringBuilder("");
        backtrack(input,s,0,0);
        Collections.sort(result);
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(new generalizedAbbrevation().genAbb(input));
        sc.close();
    }
}