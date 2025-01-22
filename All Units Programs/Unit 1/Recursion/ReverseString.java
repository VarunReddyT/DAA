import java.util.*;

/*
 * T(n)=T(n−1)+O(n)
 *  O(n^2)
 */
public class ReverseString{
    static public String reverse(String s){
        if(s.length()==0){
            return s;
        }
        String temp = s.charAt(0) + "";
        String remString = s.substring(1);
        return reverse(remString) + temp;
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        System.out.println(reverse(inp));
        sc.close();
    }
}