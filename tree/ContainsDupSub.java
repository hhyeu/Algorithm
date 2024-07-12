package tree;

import java.util.ArrayList; 
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ContainsDupSub {
	
	public static void main(String[] args) {
		Node root = new Node(0),
			 node1 = new Node(1),
			 node2 = new Node(2),
			 node3 = new Node(1);
		
		root.left = node1;
		root.right = node2;
		node2.left = node3;
		System.out.println(containsDupSub(node2));
	}
	/////<--
	
	static boolean hasDupSub(Node root, Node subRoot) {
		if (root == null || subRoot == null) return false;
		
		if (sameTree(root, subRoot)) return true;
		
		return hasDupSub(root.left, subRoot) ||
				hasDupSub(root.right, subRoot);
	}
	
	private static boolean sameTree(Node root, Node subRoot) {
		if (root == null && subRoot == null) return true;
		
		if (root == null || subRoot == null) return false;
		
		if (root.data != subRoot.data) return false;
		
		return sameTree(root.left, subRoot.left) &&
				sameTree(root.right, subRoot.right);
	}
	/////<--
	
	static boolean containsDupSub(Node root) {
		HashSet<String> file = new HashSet<String>();
		
		return helper(root, file).equals("");
	}
	
	static char marker = '#';
	
	static String helper(Node root, HashSet<String> file) {
		
		String s = "";
		
		if (root == null) return s + marker;
		
		String lstr = helper(root.left, file);
		if (lstr.equals(s)) return s;
		
		String rstr = helper(root.right, file);
		if (rstr.equals(s)) return s;
		
		s = s + root.data + "," + lstr + "," + rstr;
		
		if (file.contains(s)) return "";
		
		file.add(s);
		
		return s;
		
	}
	
	 
	
}

