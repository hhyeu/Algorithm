package tree;

public class GetDiameter {
	public static void main(String[] args) {
		Node node1 = new Node(0),
			 node2 = new Node(1),
			 node3 = new Node(1),
			 node4 = new Node(1),
			 node5 = new Node(1),
			 node6 = new Node(1),
			 node7 = new Node(1),
			 node8 = new Node(1),
			 node9 = new Node(1),
			 node10 = new Node(1),
			 node11 = new Node(1),
			 node12 = new Node(1),
			 node13 = new Node(1);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node4.left = node6;
		node4.right = node7;
		node5.right = node8;
		node7.left = node9;
		node8.left = node10;
		node8.right = node11;
		node9.right = node12;
		node11.left = node13;
		getDiameter(node1);
		System.out.println(max);
	}
	
	static int max = 0;
	
	static int getDiameter(Node root) {
		if (root == null) return 0;
		
		int left = getDiameter(root.left);
		
		int right = getDiameter(root.right);
		
		int distance = left + right;	
		
		if (distance > max) max = distance;
		
		return Math.max(left, right) + 1;
	}
}
