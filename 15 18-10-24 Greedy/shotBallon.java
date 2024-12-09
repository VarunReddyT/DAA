// There are some spherical balloons taped onto a flat wall that represents the XY-plane. 
// The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] 
// denotes a balloon whose horizontal diameter stretches between xstart and xend. 
// You do not know the exact y-coordinates of the balloons.

// Arrows can be shot up directly vertically (in the positive y-direction) from different 
// points along the x-axis. 
// A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. 
// There is no limit to the number of arrows that can be shot. 
// A shot arrow keeps traveling up infinitely, bursting any balloons in its path.

// Given the array points, return the minimum number of arrows that must be shot to burst all balloons.

// Input Format:
// -------------
// Line-1: Two integers m and n, where m is the number of balloons and n is always 2, representing the range [x_start, x_end] for each balloon.
// Line-2 to m: The next m lines contain n integers each, representing the start and end points of each balloon.

// Output Format:
// --------------
// Line-1: Print a single integer representing the minimum number of arrows required to burst all the balloons.

// Constraints:
// -------------
// *1 <= m <= 10^5 (number of balloons)
// *0 <= x_start <= x_end <= 10^9 (range of balloon positions)
// *The input is guaranteed to be such that the number of arrows needed is always finite.

// Sample Input-1:
// ---------------
// 4 2
// 10 16
// 2 8
// 1 6
// 7 12

// Sample Output-1:
// ----------------
// 2

// Sample Input-2:
// ---------------
// 4 2
// 1 2
// 3 4
// 5 6
// 7 8

// Sample Output-2:
// ----------------
// 4

// Sample Input-3:
// ---------------
// 4 2
// 1 2
// 2 3
// 3 4
// 4 5

// Sample Output-3:
// ----------------
// 2

// Sample Input-4:
// ---------------
// 8 2
// 1 2
// 2 3
// 3 4
// 4 5
// 5 6
// 6 7
// 7 8
// 8 9

// Sample Output:
// --------------
// 4

// Sample Input-5:
// ---------------
// 10 2
// 1 2
// 2 3
// 3 4
// 4 5
// 5 6
// 6 7
// 7 8
// 8 9
// 9 10
// 10 11

// Sample Output-5:
// ----------------
// 5

import java.util.*;

public class shotBallon{
    public static int minArrows(int[][] points){
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int arrows = 1;
        int end = points[0][1];
        for(int i=1; i<points.length; i++){
            if(points[i][0] > end){
                arrows++;
                end = points[i][1];
            }
        }
        return arrows;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] points = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                points[i][j] = sc.nextInt();
            }
        }
        System.out.println(minArrows(points));
        sc.close();
    }
}