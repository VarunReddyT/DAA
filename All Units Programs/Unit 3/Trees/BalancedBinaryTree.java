package Trees;
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
    public boolean isBalanced(BinaryTreeNode root) {
        if (root == null || root.data == -1)
            return true;
        return helper(root) != -1;
    }

    private int helper(BinaryTreeNode root) {
        if (root == null || root.data == -1)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right) + 1;
    }
}

public class BalancedBinaryTree {
    static BinaryTreeNode root;

    void insert(BinaryTreeNode temp, int key) {
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
            } else
                q.add(temp.left);
            if (temp.right == null) {
                temp.right = new BinaryTreeNode(key);
                break;
            } else
                q.add(temp.right);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        BalancedBinaryTree ln = new BalancedBinaryTree();
        Solution sol = new Solution();
        String str[] = sc.nextLine().split(" ");
        root = new BinaryTreeNode(Integer.parseInt(str[0]));
        for (int i = 1; i < str.length; i++)
            ln.insert(root, Integer.parseInt(str[i]));
        System.out.println(sol.isBalanced(root));
        sc.close();
    }
}