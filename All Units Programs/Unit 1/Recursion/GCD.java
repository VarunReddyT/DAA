import java.util.*;

/*
 * T(a,b)=T(b,a%b)+O(1)
 * O(log(min(a,b)))
 */
public class GCD {
    public static int calculateGCD(int a, int b) {
        // If both the number are equal
        if (a == b) {
            return a;
        }
        /* If a is equal to zero then return b */
        else if (a == 0) {
            return b;
        }
        /* If b is equal to zero then return a */
        else if (b == 0) {
            return a;
        } else if (a > b) {
            // Recursive call
            return calculateGCD(a % b, b);
        } else {
            // Recursive call
            return calculateGCD(a, b % a);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first number");
        int a = in.nextInt();
        System.out.println("Enter second number");
        int b = in.nextInt();
        System.out.println(calculateGCD(a, b));
        in.close();
    }
}