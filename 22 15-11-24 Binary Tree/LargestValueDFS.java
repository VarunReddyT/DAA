// For X-Mas, santa claus is preparing a X-Mas Tree with set of Bulbs.
// The bulbs are of different voltages, and preparation of tree as follows:
// 	- The bulbs are arranged in level-wise, levels are numbered from 0,1,2,3..
// 	  so on.
// 	- At level-0: There will be only one bulb as root bulb.,
// 	- From next level onwards, we can attach atmost two bulbs to left side,
// 	  and right side of every bulb in previous level.
// 	- The empty attachements in each level are indicated with -1. 

// You will be given the root of the X-Mas Tree,
// Your task is to findout the bulb with highest voltage in each level.

// Implement the class Solution:
// 1.public List<Integer> maxInEachRow(BinaryTreeNode root): returns the list of integers.


// Input Format:
// -------------
// A single line of space separated integers, voltages of the set of bulbs.

// Output Format:
// --------------
// Print the list of voltages.


// Sample Input-1:
// ---------------
// 2 4 3 6 4 -1 9

// Sample Output-1:
// ----------------
// [2, 4, 9]


// Sample Input-2:
// ---------------
// 3 4 7 7 3 8 4 

// Sample Output-2:
// ----------------
// [3, 4, 8]

import java.util.*;

class BinaryTreeNode
{
	public int data; 
	public BinaryTreeNode left, right; 
	public BinaryTreeNode(int data)
	{
		this.data = data; 
		left = null; 
		right = null; 
	}
}

class Solution 
{
    public List<Integer> largestValues(BinaryTreeNode root) 
	{
        //Write your code here and return a list
        List<Integer> arr = new ArrayList<>();
        helper(arr, 0, root);
        return arr;
    }
    public void helper(List<Integer> arr, int level, BinaryTreeNode root){
        if(root==null || root.data==-1){
            return;
        }
        if(level == arr.size()){
            arr.add(root.data);
        }
        arr.set(level,Math.max(arr.get(level),root.data));

        helper(arr, level+1, root.left);
        helper(arr, level+1, root.right);
    }

    //Your supporting methods(if any) goes here
}

public class LargestValueDFS 
{
	static BinaryTreeNode root;
	void insert(BinaryTreeNode temp, int key)
    { 
        if (temp == null) {
            temp = new BinaryTreeNode(key);
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(temp);
 
        // Do level order traversal until we find an empty place.
        while (!q.isEmpty()) 
		{
            temp = q.remove();

            if (temp.left == null) {
                temp.left = new BinaryTreeNode(key);
                break;
            }
            else
                q.add(temp.left);
 
            if (temp.right == null) {
                temp.right = new BinaryTreeNode(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		LargestValueDFS ln=new LargestValueDFS();
		Solution sol= new Solution();
		
		String str[]=sc.nextLine().split(" ");
		root=new BinaryTreeNode(Integer.parseInt(str[0]));
		for(int i=1; i<str.length; i++)
			ln.insert(root,Integer.parseInt(str[i]));

		System.out.println(sol.largestValues(root));
        sc.close();
	}
}
