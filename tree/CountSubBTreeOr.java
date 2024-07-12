package tree;

import java.util.ArrayList;
import java.util.List;

//Count of subtrees in a Binary Tree having bitwise OR value K
public class CountSubBTreeOr {
	public static void main(String[] args) {
		Node root = new Node(4),
			 node1 = new Node(3),
			 node2 = new Node(9),
			 node3 = new Node(2),
			 node4 = new Node(2),
			 node5 = new Node(4);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		System.out.println(countSubBTreeOr(root, 3));
	}
	static int countSubBTreeOr(Node root, int v) {
		ArrayList<Node> nodes = new ArrayList<>();
		
		helper(root, v, nodes);

		return nodes.size();
	}
	
	
	static int helper(Node root, int v, List<Node> nodes) {
		
		if (root == null) return 0;
		
		int or = root.data | 
				 helper(root.left, v, nodes) | 
				 helper(root.right, v, nodes);
		
		if (or == v) {
			nodes.add(root);
		}
		
		return or;
	}
}
