package tree;

public class TwoHalves {
	
	public static void main(String[] args) {
		Node root = new Node(0),
			 node1 = new Node(1),
			 node2 = new Node(2),
			 node3 = new Node(3);
		root.left = node1;
		root.left.left = node2;
		node1.right = node3;
		System.out.println(countChild(root));
	}
	static boolean cd = false;
	
	static int canDivide(Node root, int non) {
		
		if (root == null) return 0;
		
		int s = canDivide(root.left, non) +
				canDivide(root.right, non) +
				1;
		
		if (s * 2 == non) cd = true;
		
		return s;
	}
	
	static int countChild(Node root) {
		if (root == null) return 0;
		
		return countChild(root.left) + countChild(root.right) + 1;
	}
	
}
