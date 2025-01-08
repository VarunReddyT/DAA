import java.util.*;

public class OBSTRecursive{

    static int optCost(int freq[], int i, int j){
        if (j < i)
            return 0;
        if (j == i)
            return freq[i];
        int sum = fsum(freq, i, j);
        int min = Integer.MAX_VALUE;
        for (int r = i; r <= j; ++r){
            min = Math.min(optCost(freq, i, r-1) + optCost(freq, r+1, j), min);
        }
        return min + sum;
    }

    static int optimalSearchTree(int keys[], int freq[], int n){
        return optCost(freq, 0, n-1);
    }

    static int fsum(int freq[], int i, int j){
        int s = 0;
        for (int k = i; k <=j; k++)
            s += freq[k];
        return s;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int keys[] = new int[n];
        int freq[] = new int[n];
        for(int i = 0; i < n; i++)
        keys[i] = sc.nextInt();
        for(int i = 0; i < n; i++)
        freq[i] = sc.nextInt();
        System.out.println("Cost of Optimal BST is " + optimalSearchTree(keys, freq, n));
        sc.close();
    }
}