import java.util.*;

/*
 * T(n)=O(n)
 */

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
    public boolean isSymmetric(BinaryTreeNode root) {
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(BinaryTreeNode left, BinaryTreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.data != right.data)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}

public class SymmetricTree {
    static BinaryTreeNode root;
    static BinaryTreeNode temp = root;

    void insert(BinaryTreeNode temp, int key) {
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
        String str[] = sc.nextLine().split(" ");
        SymmetricTree st = new SymmetricTree();
        root = new BinaryTreeNode(Integer.parseInt(str[0]));
        for (int i = 1; i < str.length; i++)
            st.insert(root, Integer.parseInt(str[i]));
        Solution sol = new Solution();
        System.out.println(sol.isSymmetric(root));
        sc.close();
    }
}