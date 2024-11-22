// In a joint family, every person assigned with an ID, an integer value.
// and the entire family is arranged in the from of tree.

// You will be given the family tree,
// your task is to find and print the person ID, who is only child to his/her parent.
// i.e, the person with no siblings. Print all such person ID's in ascending order.

// NOTE: 
// 	- If only one person is there in the family, please consider him as a parent.
// 	- In the given tree, please consider '-1' as null.

// Input Format:
// -------------
// Line-1: Space separated integers, person ID's in the family.

// Output Format:
// --------------
// Line-1: Print the list of person IDs in ascending order.


// Sample Input-1:
// ---------------
// 2 3 4 -1 5

// Sample Output-1:
// ----------------
// [5]

// Sample Input-2:
// ---------------
// 11 99 88 77 -1 -1 66 55 -1 -1 44 33 -1 -1 22

// Sample Output-2:
// ----------------
// [77, 66, 55, 44, 33, 22]


import java.util.*;

class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left, right;

    public BinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    // Method to get all lonely nodes in the tree using BFS
    // Return list of lonelyNodes
    public ArrayList<Integer> getLonelyNodes(BinaryTreeNode root) {
        //Write your code here
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTreeNode currentNode = queue.poll();
            if(currentNode.left != null && currentNode.right == null){
                arr.add(currentNode.left.data);
            }
            if(currentNode.left == null && currentNode.right != null){
                arr.add(currentNode.right.data);
            }
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }
            if(currentNode.right != null){
                queue.add(currentNode.right);
            }
        }
        return arr;
    }
}

public class LonelyNodes {
    static BinaryTreeNode root;

    // Function to construct the tree based on input using level-order insertion
    BinaryTreeNode buildTreeFromInput(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) {
            return null;
        }

        root = new BinaryTreeNode(arr[0]);
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        // Traverse the input array and construct the binary tree
        while (!queue.isEmpty() && i < arr.length) {
            BinaryTreeNode currentNode = queue.poll();

            // Add left child
            if (arr[i] != null) {
                currentNode.left = new BinaryTreeNode(arr[i]);
                queue.add(currentNode.left);
            }
            i++;

            // Add right child
            if (i < arr.length && arr[i] != null) {
                currentNode.right = new BinaryTreeNode(arr[i]);
                queue.add(currentNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        LonelyNodes ln = new LonelyNodes();
        Solution sol = new Solution();

        // Read input as space-separated integers, converting -1 to null for tree structure
        String[] inputStr = sc.nextLine().split(" ");
        Integer[] nodes = new Integer[inputStr.length];
        for (int i = 0; i < inputStr.length; i++) {
            nodes[i] = inputStr[i].equals("-1") ? null : Integer.parseInt(inputStr[i]);
        }

        // Build the tree from input
        root = ln.buildTreeFromInput(nodes);

        // Get lonely nodes
        ArrayList<Integer> result = sol.getLonelyNodes(root);

        // Output result
        System.out.println(result);

        sc.close();
    }
}
