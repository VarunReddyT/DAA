// A school kid named John Doe, wants to find the value of N^P
// Pth power of a number N.

// You will be given two integers N and P.
// Your task is to help John Doe to find the value of N^P.

// NOTE:
// ---------
// Value of N and P can be both positive and negative

// Input Format:
// -------------
// Line-1: Two integers N and P, where N is the number and P is the power

// Output Format:
// --------------
// Line-1: Print a float number, N power P


// Sample Input-1:
// ---------------
// 3 2

// Sample Output-1:
// ----------------
// 9.000000


// Sample Input-2:
// ---------------
// 2 -3

// Sample Output-2:
// ----------------
// 0.125000

import java.util.*;

public class pow_SP {
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

// Another Approach Using divide and conquer

class Alternate {
    static public float power(int x, int y) {
        if (y == 0)
            return 1;
        else if (y == 1)
            return x;
        else if (y == -1)
            return (float) 1 / x;
        float res;
        int mid = (y / 2);
        float left = power(x, mid);
        float right = power(x, y - mid);
        if (y > 0)
            res = left * right;
        else
            res = left * right;// if y is -ve
        return res;
    }
}