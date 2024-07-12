package tree;

//Minimize absolute difference between sum of subtrees formed after splitting Binary tree into two
public class MinimizeDifference {
	public static void main(String[] args) {
		Node root = new Node(1),
			 node1 = new Node(2),
			 node2 = new Node(3),
			 node3 = new Node(4),
			 node4 = new Node(5),
			 node5 = new Node(6),
			 node6 = new Node(7),
			 node7 = new Node(8);
		
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		
		
		System.out.println(findMinDiff(root, getSum(root)));
	}

	
	static int findMinDiff(Node root, int sumRoot) {
		
		int[] min = new int[1];
		
		min[0] = Integer.MAX_VALUE;

		minimize(root, sumRoot, min);
		
		return min[0];
	}
	
	static int minimize(Node root, int sumRoot, int[] min) {
		if (root == null) return 0;
		
		int ls = minimize(root.left, sumRoot, min);
		
		int rs = minimize(root.right, sumRoot, min);
		
		min[0] = Math.min(min[0], Math.abs(sumRoot - 2 * (root.data + ls + rs)));

		return root.data + ls + rs;
	}
	
	static int getSum(Node root) {
		
		if (root == null) return 0;
		
		return root.data + getSum(root.left) + getSum(root.right);
	}
}
