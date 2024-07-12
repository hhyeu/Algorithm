package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FindAllDupSup {
	
	public static void main(String[] args) {
		Node root = new Node(0),
			 node1 = new Node(1),
			 node2 = new Node(2),
			 node3 = new Node(3),
			 node4 = new Node(4),
			 node5 = new Node(1),
			 node6 = new Node(2),
			 node7 = new Node(5);

		root.left = node1;
		node1.left = node2;
		root.right = node3;
		node3.left = node4;
		node4.left = node5;
		node5.left = node6;
		node5.right = node7;
		ArrayList<Node> dupSub = findAllDupSub(root);
		dupSub.forEach((node) -> {
			System.out.println(node.data);
		});
	}
	static ArrayList<Node> findAllDupSub(Node root) {
		HashMap<String, Integer> file = new HashMap<>();
		
		ArrayList<Node> dupSub = new ArrayList<>();
		
		helper(root, file, dupSub);
		
		return dupSub;
	}

	private static String helper(Node root, HashMap<String, Integer> file, ArrayList<Node> dupSub) {
		
		if (root == null) return "";
		
		String lstr = helper(root.left, file, dupSub);
		
		String rstr = helper(root.right, file, dupSub);
		
		String s = root.data + "," + lstr + "," +rstr;
		
		if (file.containsKey(s)) {
			file.put(s, file.get(s) + 1);
			dupSub.add(root);
		} else {
			file.put(s, 1);
		}
		
		return s;
	}
}
