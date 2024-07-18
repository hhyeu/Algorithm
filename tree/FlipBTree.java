package tree;

//Flip Binary Tree
public class FlipBTree {
	
	public static void main(String[] args) {
		Node root = new Node(0),
			 node1 = new Node(1),
			 node2 = new Node(2),
			 node3 = new Node(3),
			 node4 = new Node(4);
		
		root.left = node1;
		
		root = flip(root);
		Traversal.levelorder(root, true);
	}
	
	
	static Node flip(Node root) {
		
		if (root == null || root.left == null) return root;
		
		Node newRoot = flip(root.left);
		
		root.left.left = root.right;
		root.left.right = root;
		
		root.left = root.right = null;
		
		return newRoot;
	}
}
