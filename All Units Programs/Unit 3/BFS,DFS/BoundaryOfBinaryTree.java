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
