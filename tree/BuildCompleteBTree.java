package tree;

import java.util.LinkedList;
import java.util.Scanner;

//Construct Complete Binary Tree from its Linked List Representation
public class BuildCompleteBTree {
	
	
	public static void main(String[] args) {
		LinkedList<Integer> nodes = new LinkedList<Integer>();
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		for (int i = 0; i < num; i++) {
			int v = sc.nextInt();
			nodes.add(v);
		}
		
		Node root = buildCompleteBTree(nodes, 0);
		
		Traversal.postorder(root, true);
	}
	
	static int left(int k) {
		return 2*k + 1;
	}
	
	static int right(int k) {
		return 2*k + 2;
	}
	
	static Node buildCompleteBTree(LinkedList<Integer> nodes, int i) {
		if (nodes.isEmpty() || i >= nodes.size()) return null;
		
		Node root = new Node(nodes.get(i));
		
		root.left = buildCompleteBTree(nodes, left(i));
		
		root.right = buildCompleteBTree(nodes, right(i));
		
		return root;
	}
}
