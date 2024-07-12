package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Traversal {
	
	//GENERAL TREE
	//for int 
	public static void preorder(GNode root, boolean integer) {
		if (root != null) {
			System.out.print(root.data + " ");
			
			for (GNode child : root.childs) {
				preorder(child, integer);
			}
		}
	}
	
	
	
	//BINARY TREE
	//for int
	public static void preorder(Node root, boolean integer) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.left, integer);
			preorder(root.right, integer);
		}
	}
	
	public static void inorder(Node root, boolean integer) {
		if (root != null) {
			inorder(root.left, integer);
			System.out.print(root.data + " ");
			inorder(root.right, integer);
		}
	}
	
	public static void postorder(Node root, boolean integer) {
		if (root != null) {
			postorder(root.left, integer);
			postorder(root.right, integer);
			System.out.print(root.data + " ");
		}
	}
	
	public static void levelorder(Node root, boolean integer) {
		if (root == null) return;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				Node temp = queue.poll();
				
				System.out.print(temp.data + " ");
				
				if (temp.left != null) 
					queue.add(temp.left);

				if (temp.right != null) 
					queue.add(temp.right);
			}
			
		}
	}
	
	//for string
	public static void preorder(Node root) {
		if (root != null) {
			System.out.print(root.value + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.value + " ");
			inorder(root.right);
		}
	}
	
	public static void postorder(Node root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.value + " ");
		}
	}
}
