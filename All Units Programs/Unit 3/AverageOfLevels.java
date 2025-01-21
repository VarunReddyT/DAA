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
	public List<Double> averageOfLevels(BinaryTreeNode root) {
		// Write your code here and return a list
		List<Double> arr = new ArrayList<>();
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		if (root == null || root.data == -1) {
			return arr;
		}
		queue.offer(root);
		while (!queue.isEmpty()) {
			int n = queue.size();
			double sum = 0.0;
			for (int i = 0; i < n; i++) {
				BinaryTreeNode top = queue.poll();
				sum += top.data;
				if (top.left != null && top.left.data != -1) {
					queue.add(top.left);
				}
				if (top.right != null && top.right.data != -1) {
					queue.add(top.right);
				}
			}
			double avg = sum / n;
			arr.add(avg);
		}
		return arr;
	}
}

public class AverageOfLevels {
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
		AverageOfLevels ln = new AverageOfLevels();
		Solution sol = new Solution();

		String str[] = sc.nextLine().split(" ");
		root = new BinaryTreeNode(Integer.parseInt(str[0]));
		for (int i = 1; i < str.length; i++)
			ln.insert(root, Integer.parseInt(str[i]));

		System.out.println(sol.averageOfLevels(root));
		sc.close();
	}
}
