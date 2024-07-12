package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsFoldable {
	public static void main(String[] args) {
		Node root = new Node(0),
			 node1 = new Node(1),
			 node2 = new Node(2),
			 node3 = new Node(3),
			 node4 = new Node(4);
		root.left = node1;
		root.right = node2;
		node2.left = node3;
		node1.right = node4;

		System.out.println(isFoldable(root.left, root.right));
	}
	
	//using rec
	static boolean isFoldable(Node fr, Node sr) {
		if (fr == null && sr == null) return true;
		
		if (fr == null || sr == null) return false;
		
		return isFoldable(fr.left, sr.right) &&
			   isFoldable(fr.right, sr.left);
	}
	
	//using queue
	static boolean isFoldable(Node root) {
		if (root == null) return true;
		
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root.left);
		queue.add(root.right);
		
		while (!queue.isEmpty()) {
			Node l = queue.remove();
			Node r = queue.remove();
			
			if (l == null && r == null) continue;
			
			if (l == null || r == null)
				return false;
			
			queue.add(l.left);
			queue.add(r.right);
			queue.add(l.right);
			queue.add(r.left);
		}
		
		return true;
	}
}
