package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BuildMirrorTree {
	
	public static void main(String[] args) {
		Node root1 = new Node(0),
			 node1 = new Node(1),
			 node2 = new Node(2),
			 node3 = new Node(3),
			 node4 = new Node(4),
			 node5 = new Node(5);
			
		root1.left = node1;
		root1.right = node2;
		
		Traversal.inorder(root1, true);
		buildMirrorTreeLev(root1);
		System.out.println();
		Traversal.inorder(root1, true);
	}
	
	//use recursion
	static Node buildMirrorTreeRec(Node root) {
		if (root == null) return null;

		Node mirRoot = new Node(root.data);
		
		mirRoot.left = buildMirrorTreeRec(root.right);
		
		mirRoot.right = buildMirrorTreeRec(root.left);
		
		return mirRoot;
	}
	
	//use level order
	static void buildMirrorTreeLev(Node root) {
		
		if (root == null) return;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				
				Node temp = queue.poll();
				
				Node tempNode = temp.left;
				temp.left = temp.right;
				temp.right = tempNode;
				
				if (temp.left != null)
					queue.add(temp.left);
				
				if (temp.right != null)
					queue.add(temp.right);
				
			}
		}
		
	}
}
