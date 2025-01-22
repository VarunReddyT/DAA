import java.util.*;

/*
 * T(n)=T(i,k)+T(k+1,j)+O(1)
 * T(n)=O(2^n)
 */

class MatrixChainMultiplicationRecursion {
    static int MatrixChainOrder(int p[], int i, int j) {
        if (i == j)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int count = MatrixChainOrder(p, i, k);
            count += MatrixChainOrder(p, k + 1, j);
            count += p[i - 1] * p[k] * p[j];
            if (count < min)
                min = count;
        }
        return min;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(MatrixChainOrder(arr, 1, n - 1));
        sc.close();
    }
}