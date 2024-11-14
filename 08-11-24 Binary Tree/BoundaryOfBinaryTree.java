// You are tasked with building a protective boundary around a series of military camps situated along the border, represented as a binary tree structure. 
// Each node in this binary tree represents a military camp identified by a unique ID. 
// The main base camp is the root of this binary tree, with connections to other camps.

// The goal is to help the Indian Army establish a secure boundary (S.H.I.E.L.D) around these camps. 
// This boundary should be defined by the camps located at the edge of the binary tree, traced in an anti-clockwise direction, starting from the root.

// The boundary should include:
// 	-Left Boundary: The camps forming the left edge of the tree, excluding leaf camps.
// 	-Leaf Nodes: All camps that are leaf nodes, traversed from left to right.
// 	-Right Boundary: The camps forming the right edge of the tree, excluding the root and leaf camps, added in reverse order.

// You need to implement a method that outputs the IDs of the military camps located on this boundary.

// Input Format:
// -------------
// Line-1: Space-separated integers representing the IDs of the military camps in level order (top to bottom, left to right). Use -1 to denote a null or missing node.

// Output Format:
// --------------
// Line-1: A list of integers representing the military camp IDs that form the boundary, in anti-clockwise order.

// Constraints:
// ------------
//  * The tree may have between 1 and 10,000 nodes.
//  * Camp IDs are unique integers.
//  * -1 indicates a missing (null) node.

// Sample Input-1:
// ---------------
// 5 2 4 7 9 8 1

// Sample Output-1:
// ----------------
// [5, 2, 7, 9, 8, 1, 4]

// Sample Input-2:
// ---------------
// 11 2 13 4 25 6 -1 -1 -1 7 18 9 10

// Sample Output-2:
// ----------------
// [11, 2, 4, 7, 18, 9, 10, 6, 13]

// Sample Input-3:
// ---------------
// 1

// Sample Output-3:
// ----------------
// [1]

// NOTE:
// ------
// The input should be parsed and constructed into a binary tree, and your code should handle large trees efficiently.
// The boundary traversal should be handled with care, ensuring leaf nodes are only counted once in the output list.

// Function Signature:
// -------------------
// public List<Integer> boundaryOfBinaryTree(BinaryTreeNode root)

// This function will return a list of integers representing the boundary nodes of the tree in anti-clockwise order.


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
	List<Integer> nodes = new ArrayList<>();
	public List<Integer> boundaryOfBinaryTree(BinaryTreeNode root) {
	    //Write your code here and return list of nodes
	    if(root == null || root.data == -1){
			return nodes;
		}
		nodes.add(root.data);
		left(root.left);
		leaves(root.left);
		leaves(root.right);
		right(root.right);
		return nodes;
	}
	//Your supporting methods if any goes here
	public void left(BinaryTreeNode root){
		if((root == null || root.data == -1) || ((root.left == null || root.left.data == -1) && (root.right==null || root.right.data == -1))){
			return;
		}
		nodes.add(root.data);
		if(root.left == null || root.left.data == -1){
			left(root.right);
		}
		else{
			left(root.left);
		}
	}
	public void right(BinaryTreeNode root){
		if((root == null || root.data == -1) || ((root.left == null || root.left.data == -1) && (root.right==null || root.right.data == -1))){
			return;
		}
		if(root.right == null || root.right.data == -1){
			right(root.left);
		}
		else{
			right(root.right);
		}
		nodes.add(root.data);
	}
	public void leaves(BinaryTreeNode root){
		if(root == null || root.data == -1){
			return;
		}
		if((root.left == null || root.left.data == -1) && (root.right == null || root.right.data == -1)){
			nodes.add(root.data);
			return;
		}
		leaves(root.left);
		leaves(root.right);
	}
}

public class BoundaryOfBinaryTree
{
	static BinaryTreeNode root;
	void insert(BinaryTreeNode temp, int key){ 
        if (temp == null) {
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

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		BoundaryOfBinaryTree bbt=new BoundaryOfBinaryTree();
		Solution sol= new Solution();
		
		String str[]=sc.nextLine().split(" ");

		root=new BinaryTreeNode(Integer.parseInt(str[0]));

		for(int i=1; i<str.length; i++)
			bbt.insert(root,Integer.parseInt(str[i]));

		System.out.println(sol.boundaryOfBinaryTree(root));
		sc.close();
	}
}
