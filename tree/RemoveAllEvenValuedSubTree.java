package tree;

//Remove all subtrees consisting only of even valued nodes from a Binary Tree
public class RemoveAllEvenValuedSubTree {
	
	public static void main(String[] args) {
		Node root = new Node(1),
			 node1 = new Node(2),
			 node2 = new Node(7),
			 node3 = new Node(8),
			 node4 = new Node(10),
			 node5 = new Node(12),
			 node6 = new Node(5);
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		
		root = removeEven(root);
		Traversal.levelorder(root, true);
	}
	
	static Node removeEven(Node root) {
		
		if (root == null) return null;
		
		root.left = removeEven(root.left);
		
		root.right = removeEven(root.right);
		
		if (root.data % 2 == 0 && 
			root.left == null && root.right == null) 
			return null;
		
		return root;
	}
	
}
