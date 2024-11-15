// You are given a binary tree with unique values for its nodes and two distinct nodes p and q. 
// Your task is to find the Lowest Common Ancestor (LCA) of these two nodes.

// The Lowest Common Ancestor is defined as the deepest node in the binary tree 
// that has both p and q as descendants (where a node can be a descendant of itself).

// Input Format:
// -------------
// Line-1: A list of integers (space-separated) representing the binary tree in level order traversal. 
// Line-2: Two integers p and q, representing the values of the two nodes for which the LCA is to be determined.

// NOTE: Use -1 for null nodes.

// Output Format:
// --------------
// Line-1: Print the value of the Lowest Common Ancestor.

// Sample Input-1:
// ---------------
// 3 5 1 6 2 0 8 -1 -1 7 4
// 5 1

// Sample Output-1:
// ----------------
// 3

// Sample Input-2:
// ---------------
// 3 5 1 6 2 0 8 -1 -1 7 4
// 5 4

// Sample Output-2:
// ----------------
// 5

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
    public BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        //Write your code here
        return root;
    }
    public BinaryTreeNode findNode(BinaryTreeNode root, int value){
        return root;
    }
    //Your supporting methods(if any) goes here
}

public class LCA {
    static BinaryTreeNode root;

    void insert(BinaryTreeNode temp, int key) {
        if (temp == null) {
            root = new BinaryTreeNode(key);
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(temp);

        // Do level order traversal until we find an empty place
        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp.left == null) {
                temp.left = new BinaryTreeNode(key);
                break;
            } else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new BinaryTreeNode(key);
                break;
            } else
                q.add(temp.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        LCA lca = new LCA();
        root = new BinaryTreeNode(Integer.parseInt(str[0]));
        for (int i = 1; i < str.length; i++) {
            lca.insert(root, Integer.parseInt(str[i]));
        }

        int pValue = sc.nextInt();
        int qValue = sc.nextInt();

        Solution sol = new Solution();

        // Retrieve actual nodes for p and q
        BinaryTreeNode p = sol.findNode(root, pValue);
        BinaryTreeNode q = sol.findNode(root, qValue);

        if (p == null || q == null) {
            System.out.println("One or both nodes not found in the tree");
        } else {
            BinaryTreeNode res = sol.lowestCommonAncestor(root, p, q);
            System.out.println(res.data);
        }
        sc.close();
    }
}
