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
    public List<Integer> largestValues(BinaryTreeNode root) {
        // Write your code here and return a list
        List<Integer> arr = new ArrayList<>();
        if (root == null || root.data == -1) {
            return arr;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            int max = -1;
            for (int i = 0; i < n; i++) {
                BinaryTreeNode top = queue.poll();
                max = Math.max(top.data, max);
                if (top.left != null && top.left.data != -1) {
                    queue.offer(top.left);
                }
                if (top.right != null && top.right.data != -1) {
                    queue.offer(top.right);
                }
            }
            arr.add(max);
        }
        return arr;
    }

    // Your supporting methods(if any) goes here
}

public class LargestValue {
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
        LargestValue ln = new LargestValue();
        Solution sol = new Solution();

        String str[] = sc.nextLine().split(" ");
        root = new BinaryTreeNode(Integer.parseInt(str[0]));
        for (int i = 1; i < str.length; i++)
            ln.insert(root, Integer.parseInt(str[i]));

        System.out.println(sol.largestValues(root));
        sc.close();
    }
}
