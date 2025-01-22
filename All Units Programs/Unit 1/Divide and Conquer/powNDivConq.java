import java.util.*;

/*
 * The problem size reduces by half at each step.
    * The number of steps is proportional to log ⁡2(𝑦)
    * Thus, the time complexity is:
    * T(y)=2T(y/2)+O(1)
    * T(y)=O(logy)
 */
public class powNDivConq {
    static public float power(int x, int y) {
        if (y == 0) {
            return 1;
        }
        float temp, res;
        temp = power(x, y / 2);
        if (y % 2 == 0) {
            res = temp * temp;
        } else {
            if (y > 0) {
                res = x * temp * temp;
            } else {
                res = (temp * temp) / x;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        System.out.println(power(n, p));
        sc.close();
    }
}
