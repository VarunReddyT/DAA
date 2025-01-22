import java.util.*;

public class StrobogrammaticNumberII {

    static char[][] digitPair = { { '1', '1' }, { '8', '8' }, { '6', '9' }, { '9', '6' } };

    public static ArrayList<String> isStrobogrammatic(int n) {
        return helper(n, n);
    }

    public static ArrayList<String> helper(int n, int m) {
        if (n == 0) {
            return new ArrayList<String>(Arrays.asList(""));
        }
        if (n == 1) {
            return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        }

        ArrayList<String> list = helper(n - 2, m);
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (n != m) {
                res.add("0" + s + "0");
            }
            for (char[] singlePair : digitPair) {
                res.add(singlePair[0] + s + singlePair[1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> out = isStrobogrammatic(n);
        Collections.sort(out);
        System.out.println(out);

        sc.close();
    }

}