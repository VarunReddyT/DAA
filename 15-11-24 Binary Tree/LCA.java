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
        if(root == null ||  root==p || root==q){
            return root;
        }
        BinaryTreeNode left = lowestCommonAncestor(root.left,p,q);
        BinaryTreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null){
            return root;
        }
        if(left != null){
            return left;
        }
        return right;
        
    }

    //Your supporting methods(if any) goes here
    public BinaryTreeNode findNode(BinaryTreeNode root, int value){
        if(root==null || root.data==-1){
            return null;
        }
        if(root.data == value){
            return root;
        }
        BinaryTreeNode left = findNode(root.left,value);
        if(left!=null){
            return left;
        }
        BinaryTreeNode right = findNode(root.right,value);
        return right;
    }
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
