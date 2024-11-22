// Mr. Rishil is interested to work on Data Structures.
// He has constructed a BinaryTree-BT.

// He asked his friend Mr. Anil to check whether BT is a balanced BT or not.
// A balanced BT is defined as follows:
//     - The binary tree in which the left and right subtrees of every node 
//     differ in height by no more than 1.

// Can you help Mr. Anil to find and return "true" if the given BT is a balanced tree,
// otherwise return "false".

// Implement the class Solution:
//    1. public boolean isBalanced(BinaryTreeNode root): returns a boolean value.

// NOTE:
// 	- In the tree '-1', indicates empty(null).
   
// Input Format:
// -------------
// Line-1: Space separated integers, values at the treenode

// Output Format:
// --------------
// Line-1: A boolean value.


// Sample Input-1:
// ---------------
// 2 1 1 2 3 3 2

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// 1 2 3 4 5 -1 -1 6 7

// Sample Output-2:
// ----------------
// false

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
	public boolean isBalanced(BinaryTreeNode root) 
	{
        //Write your code here and return a boolean value
        int res = height(root);
        return res!=-1;
    }

    //Your supporting methods(if any) goes here
    int height(BinaryTreeNode root){
        if(root == null || root.data==-1){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        if(left == -1 || right == -1 || Math.abs(left-right) > 1){
            return -1;
        }
        return Math.max(left,right)+1;
    }    
}

public class BalancedBinaryTree
{
	static BinaryTreeNode root;
	void insert(BinaryTreeNode temp, int key)
    { 
        if (temp == null) 
		{
            temp = new BinaryTreeNode(key);
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(temp);
 
        // Do level order traversal until we find an empty place.
        while (!q.isEmpty()) {
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
		BalancedBinaryTree ln=new BalancedBinaryTree();
		Solution sol= new Solution();
		
		String str[]=sc.nextLine().split(" ");
		root=new BinaryTreeNode(Integer.parseInt(str[0]));
		for(int i=1; i<str.length; i++)
			ln.insert(root,Integer.parseInt(str[i]));

		System.out.println(sol.isBalanced(root));
        sc.close();
	}
}
