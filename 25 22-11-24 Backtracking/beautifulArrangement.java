// Ganesh is working on numbers,
// He is given a list of integers 1,2,3,...,N, the list is indexed from 1 to N.

// Now he can shuffle the list in whatever way he want.
// Shuffled list is said to be valid, if one of the following is true for i-th position in the list.
// 	- The integer at the i-th position is divisible by i.
// 	- 'i' is divisible by the integer at the i-th position.

// Now your task is to find out, How many valid shuffles can Ganesh do?

// Input Format:
// -------------
// Line-1: An integer N, where N<=20.

// Output Format:
// --------------
// Line-1: Print an integer, number of ways ganesh can shuffle.


// Sample Input:
// ---------------
// 2

// Sample Output:
// ----------------
// 2

// Explanation:
// ------------
// The first shuffled list is [1, 2]:
// Integer at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
// Integer at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

// The second shuffled list is [2, 1]:
// Integer at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
// Integer at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.

import java.util.*;

public class beautifulArrangement{
    public static int countArrangement(int n) {
        int[] count = new int[1];
        boolean[] visited = new boolean[n+1];
        countArrangementUtil(n,1,visited,count);
        return count[0];
    }
    
    public static void countArrangementUtil(int n, int pos, boolean[] visited, int[] count){
        if(pos>n){
            count[0]++;
            return;
        }
        
        for(int i=1;i<=n;i++){
            if(!visited[i] && (i%pos==0 || pos%i==0)){
                visited[i] = true;
                countArrangementUtil(n,pos+1,visited,count);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countArrangement(n));
        sc.close();
    }
}