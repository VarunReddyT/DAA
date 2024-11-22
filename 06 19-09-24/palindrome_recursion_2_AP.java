import java.util.*;
public class palindrome_recursion_2_AP {
    public static String check(String subWord, int len, int cur){
        if(cur == len){
            return "";
        }
        String res = check(subWord,len,cur+1);
        res += subWord.substring(cur, cur+1);
        return res;


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        String res = check(word,word.length(),0);

        if(res.equals(word)){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }

        sc.close();
    }
}
