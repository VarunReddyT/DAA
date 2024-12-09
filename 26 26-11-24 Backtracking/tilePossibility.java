// You are given a string of uppercase English letters representing letter tiles. Each letter tile can be used once per combination. 
// Your task is to determine the total number of possible sequences that can be formed using these letter tiles.

// Rules:
// 	-The order of letters in a sequence matters.
// 	-A sequence can consist of any number of tiles (from 1 to the total number of tiles).
// 	-Duplicate tiles may lead to duplicate sequences, so consider each sequence as unique.

// Input Format:
// -------------
// Line-1: A string tiles, where 1 ≤ tiles.length ≤ 7 and each character is an uppercase English letter.

// Output Format:
// --------------
// Line-1: An integer representing the total number of unique sequences that can be formed.

// Sample Input-1:
// ---------------
// AAB

// Sample Output-1:
// ----------------
// 8

// Explanation:
// The sequences are: A, B, AA, AB, BA, AAB, ABA, BAA.

// Sample Input-2:
// ---------------
// AAABBC

// Sample Output-2:
// ----------------
// 188

import java.util.*;

public class tilePossibility{
    public static int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) {
            count[c - 'A']++;
        }
        return dfs(count);
    }

    private static int dfs(int[] count) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                continue;
            }
            sum++;
            count[i]--;
            sum += dfs(count);
            count[i]++;
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String tiles = sc.next();
        System.out.println(numTilePossibilities(tiles));
        sc.close();
    }
}