// Ramesh is interested to work on Data Structures.
// He has constructed BinaryTree-BT.

// He asked his friend Gopal to check whether BT is self mirror tree or not.
// Can you help Gopal to find and return "true" if BT is a self mirror tree,
// otherwise return "false"

// Implement the class Solution:
//    1. public boolean isSelfMirrorTree(BinaryTreeNode root): returns a boolean value.
  
// NOTE:
// 	- In the tree '-1', indicates empty(null).
   
// Input Format:
// -------------
// Line-1: Space separated integers, values at the treenode

// Output Format:
// --------------
// Line-1: Print a boolean value.


// Sample Input-1:
// ---------------
// 2 1 1 2 3 3 2

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// 2 1 1 -1 3 -1 3

// Sample Output-2:
// ----------------
// false

import java.util.*;

class BinaryTreeNode{
	public int data; 
	public BinaryTreeNode left, right; 
	public BinaryTreeNode(int data){
		this.data = data; 
		left = null; 
		right = null; 
	}
}

class Solution{
    //Write your code here and return boolean value
    boolean checkMirror(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        else if((root1 == null && root2 != null) || (root1 != null && root2 == null)){
            return false;
        }
        boolean left = checkMirror(root1.left,root2.right);
        boolean right = checkMirror(root1.right,root2.left);
        if(left && right && (root1.data == root2.data)){
            return true;
        }
        else{
            return false;
        }
    }
    boolean isSymmetric(BinaryTreeNode root){
        return checkMirror(root.left,root.right);
    }
}

public class SymmetricTree{
	static BinaryTreeNode root;
	static BinaryTreeNode temp = root;
	void insert(BinaryTreeNode temp, int key){ 
        if (temp == null) {
            root = new BinaryTreeNode(key);
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
		String str[]=sc.nextLine().split(" ");
		SymmetricTree st=new SymmetricTree();
		root=new BinaryTreeNode(Integer.parseInt(str[0]));
		for(int i=1; i<str.length; i++)
			st.insert(root,Integer.parseInt(str[i]));
		Solution sol= new Solution();
		System.out.println(sol.isSymmetric(root));
        sc.close();
	}
}