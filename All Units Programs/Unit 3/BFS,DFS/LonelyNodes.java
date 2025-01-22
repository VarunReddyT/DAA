
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
