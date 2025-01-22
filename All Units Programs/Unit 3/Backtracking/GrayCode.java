import java.util.*;

/*
 * T(n)=O(2^n)
 */
public class GrayCode {
    int n;

    public List<Integer> grayCode() {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        grayCodeHelper(result, 0);
        return result;
    }

    private boolean grayCodeHelper(List<Integer> result, int current) {
        if (result.size() == (1 << n)) {
            return true; // Valid sequence found
        }
        for (int i = 0; i < n; i++) {
            int next = current ^ (1 << i); // Flip the ith bit
            if (!result.contains(next)) { // Ensure no duplicates
                result.add(next);
                if (grayCodeHelper(result, next)) {
                    return true; // If valid sequence, return immediately
                }
                // Backtrack
                result.remove(result.size() - 1);
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        GrayCode gc = new GrayCode();
        gc.n = sc.nextInt();
        System.out.println(gc.grayCode());
        sc.close();
    }
}