// Balbir singh is working with Binary Trees.
// The elements of the tree is given in the level order format.
// Balbir is looking the tree from right side. 
// So, he can view only rightmost nodes only (one node per level).

// You will be given the root of the binary tree.
// Your task is to find the nodes which can be viewed by Balbir from right side.
// And print the nodes from top to bottom order.

// Your task is to implement the class Solution:
// 	- public List<Integer> rightSideView(BinaryTreeNode root):
// 	return the list of node values.
	
// NOTE: 
// Please do consider the node with data=-1 as null node in the given trees.

// Input Format:
// -------------
// Space separated integers, elements of the tree.

// Output Format:
// --------------
// Print a boolean value.

// Sample Input-1:
// ---------------
// 1 2 3 5 -1 -1 5

// Sample Output-1:
// ----------------
// [1, 3, 5]

// Sample Input-2:
// ---------------
// 3 2 4 3 2

// Sample Output-2:
// ----------------
// [3, 4, 2]


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
    public List<Integer> rightSide(BinaryTreeNode root) 
	{
        //Write your code here and return a list
        List<Integer> arr = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if(root==null || root.data==-1){
            return arr;
        }
        queue.add(root);
        arr.add(root.data);
        // while(!queue.isEmpty()){
        //     BinaryTreeNode top = queue.poll();
        //     if(top.right != null || top.right.data != -1){
        //         queue.offer(top.right);
        //     }
        //     if(top.left != null || top.left.data != -1){
        //         queue.offer(top.left);
        //     }
        //     arr.add(queue.peek().data);

             // queue.offer()

        // }
        return arr;
    }
    //Your supporting methods(if any) goes here  
}

public class RightSideViewBFS 
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
		RightSideViewBFS ln=new RightSideViewBFS();
		Solution sol= new Solution();
		
		String str[]=sc.nextLine().split(" ");
		root=new BinaryTreeNode(Integer.parseInt(str[0]));
		for(int i=1; i<str.length; i++)
			ln.insert(root,Integer.parseInt(str[i]));

		System.out.println(sol.rightSide(root));
        sc.close();
	}
}
