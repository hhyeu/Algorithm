package tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {
	public static void main(String[] args) {
		Node root = new Node(0),
			 node1 = new Node(1),
			 node2 = new Node(1);
		
		root.left = node1;
		root.right = node2;
		
		System.out.println(isSymmetric(root));
	}
	
	static boolean isSymmetric(Node fr, Node sr) {
		if (fr == null && sr == null) return true;
		
		if (fr == null || sr == null) return false;
		
		return fr.data == sr.data &&
			   isSymmetric(fr.left, sr.right) &&
			   isSymmetric(fr.right, sr.left);
	}
	
	static boolean isSymmetric(Node root) {
		
		if (root == null) return true;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root.left);
		queue.add(root.right);
		
		while (!queue.isEmpty()) {
			Node l = queue.remove();
			Node r = queue.remove();
			
			if (l == null && r == null) continue;
			
			if (l == null || r == null ||
				l.data != r.data) 
				return false;
			
			queue.add(l.left);
			queue.add(r.right);
			queue.add(l.right);
			queue.add(r.left);
		}
		
		return true;
	}
}
