package DP;
public class FibonacciTabulation {
    static int[] F = new int[50];

    public static int fibonacciBottomUp(int n) {
        F[n] = 0;
        F[1] = 1;
        for (int i = 2; i <= n; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }
        return F[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacciBottomUp(46));
    }
}