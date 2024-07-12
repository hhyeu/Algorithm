package tree;

import java.util.HashMap;
import java.util.HashSet;

//general tree
public class CountDupSub {
	public static void main(String[] args) {
		GNode root = new GNode(0),
			  node1 = new GNode(1),
			  node2 = new GNode(2),
			  node3 = new GNode(3),
			  node4 = new GNode(4),
			  node5 = new GNode(1),
			  node6 = new GNode(2),
			  node7 = new GNode(5);
		root.childs.add(node1);
		root.childs.add(node3);
		root.childs.add(node4);
		node1.childs.add(node2);
		node3.childs.add(node5);
		node5.childs.add(node6);
		node4.childs.add(node7);
		System.out.println(countDupSub(root));
		Traversal.preorder(root, true);
	}
	
	static int countDupSub(GNode root) {
		HashMap<String, Integer> file = new HashMap<>();
		
		helper(root, file);
		
		int count = 0; 
		
		for (Integer value : file.values()) {
			if (value > 1) count++;
		}
		
		return count;
	}
	
	
	static String helper(GNode root, HashMap<String, Integer> file) {
		
		if (root == null) return "";
		
		String s = String.valueOf(root.data);
		
		for (GNode child : root.childs) {
			s += helper(child, file);
		}
		
		if (file.containsKey(s)) {
			file.replace(s, file.get(s) + 1);
		} else {
			file.put(s, 1);
		}
		
		return s;
		
	}
	
	
}
