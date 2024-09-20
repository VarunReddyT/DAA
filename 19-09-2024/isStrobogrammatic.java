import java.util.*;
public class isStrobogrammatic {

    
    // public static boolean check(int n, HashMap<Character,Character> map,int i, intj){
        
    // }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        map.put('0', '0');
        map.put('1','1');
        map.put('8','8');
        map.put('6','9');
        map.put('9','6');

        // boolean res = check(n,map,0,map.size()-1);
        
        // System.out.println(res);
        sc.close();
    }
}
