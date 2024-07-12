package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BuildTreePreorder {
	public static void main(String[] args) {
		Node root = new Node(0),
			 node1 = new Node(1),
			 node2 = new Node(2),
			 node3 = new Node(3),
			 node4 = new Node(4);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node4.right = new Node(5);
		
		List<Integer> preorder = new ArrayList<>();
		
		preorder = getPreorderList(root, preorder);
		
		root = buildTreePreorder(preorder);
		Traversal.preorder(root, true);
	}
	
	static int i = 0;
	
	static Node buildTreePreorder(List<Integer> preorder) {
		if (preorder.get(i) == null) return null;
		
		Node root = new Node(preorder.get(i));
		
		i++;
		root.left = buildTreePreorder(preorder);
			
		i++;
		root.right = buildTreePreorder(preorder);
		
		return root;
	}
	
	private static List<Integer> getPreorderList(Node root, List<Integer> preorder) {
		
		if (root == null) {
			preorder.add(null);
		} else {
			preorder.add(root.data);
			preorder = getPreorderList(root.left, preorder);
			preorder = getPreorderList(root.right, preorder);
		}
		
		return preorder;
	}
}
