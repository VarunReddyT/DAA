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
    public List<Integer> rightSide(BinaryTreeNode root) {
        // Write your code here and return a list
        List<Integer> arr = new ArrayList<>();
        helper(arr, 0, root);
        return arr;
    }

    public void helper(List<Integer> arr, int currDepth, BinaryTreeNode root) {
        if (root == null || root.data == -1) {
            return;
        }
        if (currDepth == arr.size()) {
            arr.add(root.data);
        }
        helper(arr, currDepth + 1, root.right);
        helper(arr, currDepth + 1, root.left);
    }

    // Your supporting methods(if any) goes here
}

public class RightSideViewDFS {
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
        RightSideViewDFS ln = new RightSideViewDFS();
        Solution sol = new Solution();

        String str[] = sc.nextLine().split(" ");
        root = new BinaryTreeNode(Integer.parseInt(str[0]));
        for (int i = 1; i < str.length; i++)
            ln.insert(root, Integer.parseInt(str[i]));

        System.out.println(sol.rightSide(root));
        sc.close();
    }
}
